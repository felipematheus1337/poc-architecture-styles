package poc_broker_topology.v1.infra.presentation;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poc_broker_topology.v1.application.CreateNoteUseCase;
import poc_broker_topology.v1.domain.model.Note;
import poc_broker_topology.v1.infra.builder.NoteBuilder;
import poc_broker_topology.v1.infra.dtos.CreateNoteRequest;
import poc_broker_topology.v1.infra.dtos.NoteResponseDto;

@RestController
@RequestMapping("/api/v1/notes")
@AllArgsConstructor
public class NoteController {

    private final CreateNoteUseCase createNoteUseCase;
    private final NoteBuilder builder;

    public ResponseEntity<NoteResponseDto> create(@RequestBody CreateNoteRequest request) {

        Note note = builder.toNote(request);

        NoteResponseDto response = builder.toResponse(createNoteUseCase.create(note));

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }

}
