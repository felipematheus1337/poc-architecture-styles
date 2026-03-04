package poc_layered_architecture.v1.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poc_layered_architecture.v1.business.mapper.JobMapper;
import poc_layered_architecture.v1.persistence.entity.Job;
import poc_layered_architecture.v1.persistence.entity.enums.JobStatus;
import poc_layered_architecture.v1.persistence.entity.enums.StepStatus;
import poc_layered_architecture.v1.persistence.repository.JobRepository;
import poc_layered_architecture.v1.persistence.repository.StepExecutionRepository;
import poc_layered_architecture.v1.presentation.dtos.JobRequest;
import poc_layered_architecture.v1.presentation.dtos.JobResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final static Logger log = LoggerFactory.getLogger(JobService.class);
    private final JobRepository jobRepository;
    private final JobMapper mapper;

    public JobService(JobRepository jobRepository, JobMapper mapper) {
        this.jobRepository = jobRepository;
        this.mapper = mapper;
    }

    @Transactional
    public JobResponse createJob(JobRequest request) {
        log.info("::: CREATING AN JOB -> {}", request);
        Job job = this.mapper.toDomain(request);
        createdJobBusinessLogic(job);
        return mapper.toResponse(jobRepository.save(job));
    }

    @Transactional
    public JobResponse startAJob(Long id) {
        log.info("::: Starting AN JOB with id -> {}", id);
        Optional<Job> optJob = jobRepository.findById(id);

        if (optJob.isEmpty()) return null;

        Job job = optJob.get();

        if (job.getStatus() != JobStatus.CREATED)
            throw new RuntimeException("Job already started/running/done.");

        job.setStatus(JobStatus.RUNNING);
        fillJobStepExecution(job, StepStatus.RUNNING);

        return mapper.toResponse(jobRepository.save(job));
    }

    public JobResponse getAJob(Long id) {
        return mapper.toResponse(jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()));
    }

    public List<JobResponse> list() {
        return jobRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    private void createdJobBusinessLogic(Job job) {
        job.setCreatedAt(LocalDateTime.now());
        job.setStatus(JobStatus.CREATED);
        job.setStartedAt(null);
        job.setFinishedAt(null);

        job.getSteps()
                .forEach(step -> step.setStatus(StepStatus.PENDING));

    }

    private void fillJobStepExecution(Job job, StepStatus status) {

        job.getSteps().forEach(step -> step.setStatus(status));
    }
}
