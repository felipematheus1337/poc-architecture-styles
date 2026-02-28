package poc_layered_architecture.v1.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepExecutionRepository extends JpaRepository<StepExecutionRepository, Long> {
}
