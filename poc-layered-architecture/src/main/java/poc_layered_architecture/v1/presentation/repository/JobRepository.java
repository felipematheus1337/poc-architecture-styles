package poc_layered_architecture.v1.presentation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc_layered_architecture.v1.presentation.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
