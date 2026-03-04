package poc_pipeline_architecture.v1.business.pipelines.pipes;

import org.springframework.stereotype.Component;
import poc_pipeline_architecture.v1.business.pipelines.context.CreateJobContext;
import poc_pipeline_architecture.v1.business.pipelines.filters.*;
import poc_pipeline_architecture.v1.presentation.dtos.JobRequest;
import poc_pipeline_architecture.v1.presentation.dtos.JobResponse;

import java.util.List;

@Component
public class CreateJobPipeline {

    private final List<Filter<CreateJobContext>> steps;

    public CreateJobPipeline(
            JobRequestToDomainFilter jobRequestToDomainFilter,
            CreateJobBusinessLogicFilter createJobBusinessLogicFilter,
            PersistAJobFilter<CreateJobContext> persistAJobFilter,
            CreateJobToResponseFilter responseFilter
    ) {
        this.steps = List.of(jobRequestToDomainFilter, createJobBusinessLogicFilter, persistAJobFilter, responseFilter);
    }

    public JobResponse execute(JobRequest request) {
        var ctx = new CreateJobContext(request);
        for (var step: steps) step.apply(ctx);
        return ctx.response;
    }
}
