package poc_broker_topology.v1.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc_broker_topology.v1.domain.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
