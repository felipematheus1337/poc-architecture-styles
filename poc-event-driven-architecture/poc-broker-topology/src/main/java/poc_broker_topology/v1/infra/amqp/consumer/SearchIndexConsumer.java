package poc_broker_topology.v1.infra.amqp.consumer;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import poc_broker_topology.v1.infra.amqp.dtos.EventNote;
import poc_broker_topology.v1.infra.amqp.dtos.NoteEventDto;
import poc_broker_topology.v1.infra.event.ProcessedEvent;
import poc_broker_topology.v1.infra.exceptions.ConsumerStreamException;
import poc_broker_topology.v1.infra.repository.ProcessedEventsRepository;

import java.time.LocalDateTime;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class SearchIndexConsumer implements Consumer<Message<NoteEventDto>> {

    private final ProcessedEventsRepository processedEventsRepository;
    private static final String SEARCH_INDEX_NAME = "SearchIndexConsumer";

    @Override
    @Transactional
    public void accept(Message<NoteEventDto> noteEventDtoMessage) {
        var payload = noteEventDtoMessage.getPayload();
        if (payload == null) throw new ConsumerStreamException("empty payload.");
        checkIdempotency(payload.getEventId());
        ProcessedEvent event = createProcessedEvent(payload);
        processedEventsRepository.save(event);
    }

    private ProcessedEvent createProcessedEvent(NoteEventDto payload) {
        return ProcessedEvent
                .builder()
                .processedAt(LocalDateTime.now())
                .consumer(SEARCH_INDEX_NAME)
                .indexedText(createIndexedText(payload.getData()))
                .eventId(payload.getEventId())
                .build();
    }

    private String createIndexedText(EventNote data) {
        return data.title() + data.content();
    }

    private void checkIdempotency(String eventId) {
        if(processedEventsRepository.existsByEventId(eventId)) throw new RuntimeException("Already processed.");

    }


}
