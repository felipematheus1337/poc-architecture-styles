package poc_layered_architecture.v1.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc_layered_architecture.v1.persistence.entity.StepExecution;

@Repository
public interface StepExecutionRepository extends JpaRepository<StepExecution, Long> {
}
