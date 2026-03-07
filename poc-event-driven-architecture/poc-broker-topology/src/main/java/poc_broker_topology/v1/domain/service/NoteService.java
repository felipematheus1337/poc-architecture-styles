package poc_broker_topology.v1.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import poc_broker_topology.v1.domain.model.Note;
import poc_broker_topology.v1.infra.amqp.producer.CreateNoteEventProducer;
import poc_broker_topology.v1.infra.repository.NoteRepository;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository repository;
    private final CreateNoteEventProducer producer;

    @Transactional
    public Note create(Note note) {
     verifyNote(note);
     Note noteCreated = repository.save(note);
     producer.publish(noteCreated);
     return noteCreated;
    }

    private void verifyNote(Note note) {
        Assert.notNull(note, "Object is null.");
        Assert.notNull(note.getContent(), "A note need a content.");
        Assert.notNull(note.getTitle(), "A note need a title.");
    }
}
