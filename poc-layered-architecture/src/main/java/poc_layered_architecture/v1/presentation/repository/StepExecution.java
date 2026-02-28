package poc_layered_architecture.v1.presentation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepExecution extends JpaRepository<StepExecution, Long> {
}
