package poc_pipeline_architecture.v1.business.mapper;

import org.springframework.stereotype.Component;
import poc_pipeline_architecture.v1.persistence.entity.Job;
import poc_pipeline_architecture.v1.persistence.entity.StepExecution;
import poc_pipeline_architecture.v1.presentation.dtos.JobRequest;
import poc_pipeline_architecture.v1.presentation.dtos.JobResponse;
import poc_pipeline_architecture.v1.presentation.dtos.StepExecutionRequest;
import poc_pipeline_architecture.v1.presentation.dtos.StepExecutionResponse;

import java.util.List;

@Component
public class JobMapper {

    public Job toDomain(JobRequest request) {

        Job job = new Job();
        job.setName(request.name());
        job.setSteps(toDomainList(request.steps()));


        return job;

    }

    public StepExecution toStepExecutionDomain(StepExecutionRequest request) {
        StepExecution stepExecution = new StepExecution();
        stepExecution.setStepName(request.name());
        stepExecution.setOrder(request.order());
        return stepExecution;

    }

    private List<StepExecution> toDomainList(List<StepExecutionRequest> request) {
        return request
                .stream()
                .map(this::toStepExecutionDomain)
                .toList();
    }


    public JobResponse toResponse(Job job) {
        JobResponse jobResponse = new JobResponse(
                job.getId(),
                job.getName(),
                job.getStatus().toString(),
                job.getCreatedAt(),
                job.getStartedAt(),
                job.getFinishedAt(),
                stepExecutionResponseList(job.getSteps())
        );

        return jobResponse;
    }

    public StepExecutionResponse toStepExecutionResponse(StepExecution execution) {
        return new StepExecutionResponse(execution.getStepName(), execution.getOrder(), execution.getStatus().toString());
    }

    private List<StepExecutionResponse> stepExecutionResponseList(List<StepExecution> steps) {
        return steps
                .stream()
                .map(this::toStepExecutionResponse)
                .toList();
    }
}
