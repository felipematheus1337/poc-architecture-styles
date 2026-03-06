package poc_broker_topology.v1.application;

import poc_broker_topology.v1.domain.model.Note;

public interface CreateNoteUseCase {

    Note create(Note note);
}
