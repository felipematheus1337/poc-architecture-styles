package poc_layered_architecture.v1.business;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import poc_layered_architecture.v1.persistence.repository.JobRepository;
import poc_layered_architecture.v1.persistence.repository.StepExecutionRepository;
import poc_layered_architecture.v1.presentation.dtos.JobRequest;
import poc_layered_architecture.v1.presentation.dtos.JobResponse;

import java.util.List;

@Service
public class JobService {

    private final static Logger log = LoggerFactory.getLogger(JobService.class);
    private final JobRepository jobRepository;
    private final StepExecutionRepository stepExecutionRepository;

    public JobService(JobRepository jobRepository, StepExecutionRepository stepExecutionRepository) {
        this.jobRepository = jobRepository;
        this.stepExecutionRepository = stepExecutionRepository;
    }

    public JobResponse createJob(JobRequest request) {
    }

    public JobResponse startAJob(Long id) {
    }

    public JobResponse getAJob(Long id) {
    }

    public List<JobResponse> list() {
    }
}
