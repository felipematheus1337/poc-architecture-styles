package poc_broker_topology.v1.infra.amqp.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import poc_broker_topology.v1.infra.exceptions.ProducerStreamException;
import poc_broker_topology.v1.domain.model.Note;
import poc_broker_topology.v1.infra.amqp.dtos.EventNote;
import poc_broker_topology.v1.infra.amqp.dtos.NoteEventDto;
import poc_broker_topology.v1.infra.builder.NoteBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class CreateNoteEventProducer {

    private static final String CREATE_NOTE_OUT = "createNote-out-0";
    private static final String EVENT_TYPE = "CreateNote";
    private static final String CREATE_NOTE_VERSION = "v1";
    private final StreamBridge producer;
    private final NoteBuilder builder;

    public void publish(Note note) {
        log.info("Started publishing the message.");
        Message<NoteEventDto> payload = createNotePayload(note);
        boolean isMessagePublished =  this.producer.send(CREATE_NOTE_OUT, payload);

        if (!isMessagePublished) throw new ProducerStreamException("Failed to send the message of the note: " + note.toString());

        log.info("Message published sucessfully.");
    }

    private Message<NoteEventDto> createNotePayload(Note note) {

        EventNote eventNote = builder.toEventNote(note);
        String eventId = UUID.randomUUID() + note.getId().toString();

        var payload = NoteEventDto
                .builder()
                .eventId(eventId)
                .eventType(EVENT_TYPE)
                .timestamp(LocalDateTime.now())
                .version(CREATE_NOTE_VERSION)
                .data(eventNote)
                .build();


        return MessageBuilder
                .withPayload(payload)
                .setHeader("correlationId", eventId)
                .build();
    }


}
