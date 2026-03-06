package poc_broker_topology.v1.infra.builder;

import org.springframework.stereotype.Component;
import poc_broker_topology.v1.domain.model.Note;
import poc_broker_topology.v1.infra.dtos.CreateNoteRequest;
import poc_broker_topology.v1.infra.dtos.NoteResponseDto;

@Component
public class NoteBuilder {

    public Note toNote(CreateNoteRequest request) {
        return Note
                .builder()
                .title(request.title())
                .content(request.content())
                .build();
    }

    public NoteResponseDto toResponse(Note note) {
        return NoteResponseDto
                .builder()
                .title(note.getTitle())
                .content(note.getContent())
                .build();
    }
}
