package poc_broker_topology.v1.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import poc_broker_topology.v1.domain.model.Note;
import poc_broker_topology.v1.infra.repository.NoteRepository;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository repository;

    @Transactional
    public Note create(Note note) {
     verifyNote(note);
     return repository.save(note);

    }

    private void verifyNote(Note note) {
        Assert.isNull(note, "Object is null.");
        Assert.isNull(note.getContent(), "A note need a content.");
        Assert.isNull(note.getTitle(), "A note need a title.");
    }
}
