package poc_broker_topology.v1.infra.out;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import poc_broker_topology.v1.application.CreateNoteUseCase;
import poc_broker_topology.v1.domain.model.Note;
import poc_broker_topology.v1.domain.service.NoteService;
import poc_broker_topology.v1.infra.builder.NoteBuilder;

@Service
@AllArgsConstructor
public class CreateNoteUseCaseImpl implements CreateNoteUseCase {

    private final NoteService noteService;

    @Override
    public Note create(Note note) {
        return noteService.create(note);
    }
}
