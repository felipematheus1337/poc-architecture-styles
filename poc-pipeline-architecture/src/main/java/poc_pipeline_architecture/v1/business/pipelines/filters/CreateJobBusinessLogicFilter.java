package poc_pipeline_architecture.v1.business.pipelines.filters;

import org.springframework.stereotype.Component;
import poc_pipeline_architecture.v1.business.pipelines.context.CreateJobContext;
import poc_pipeline_architecture.v1.persistence.entity.Job;
import poc_pipeline_architecture.v1.persistence.entity.enums.JobStatus;
import poc_pipeline_architecture.v1.persistence.entity.enums.StepStatus;

import java.time.LocalDateTime;

@Component
public class CreateJobBusinessLogicFilter implements Filter<CreateJobContext> {

    @Override
    public void apply(CreateJobContext tContext) {
        Job job = tContext.job;

        job.setCreatedAt(LocalDateTime.now());
        job.setStatus(JobStatus.CREATED);
        job.setStartedAt(null);
        job.setFinishedAt(null);

        job.getSteps()
                .forEach(step -> step.setStatus(StepStatus.PENDING));
    }
}
