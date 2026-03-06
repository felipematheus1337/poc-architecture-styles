package poc_broker_topology.v1.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc_broker_topology.v1.infra.event.ProcessedEvent;

import java.util.Optional;

@Repository
public interface ProcessedEventsRepository extends JpaRepository<ProcessedEvent, String> {


    boolean existsByEventId(String eventId);
}
