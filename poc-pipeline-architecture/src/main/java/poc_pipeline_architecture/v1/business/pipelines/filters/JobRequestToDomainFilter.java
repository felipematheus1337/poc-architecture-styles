package poc_pipeline_architecture.v1.business.pipelines.filters;

import org.springframework.stereotype.Component;
import poc_pipeline_architecture.v1.business.mapper.JobMapper;
import poc_pipeline_architecture.v1.business.pipelines.context.CreateJobContext;
import poc_pipeline_architecture.v1.persistence.entity.Job;
import poc_pipeline_architecture.v1.presentation.dtos.JobRequest;

@Component
public class JobRequestToDomainFilter implements Filter<CreateJobContext> {

    private final JobMapper mapper;

    public JobRequestToDomainFilter(JobMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void apply(CreateJobContext tContext) {
        JobRequest request = tContext.request;
        Job domain = mapper.toDomain(request);
        tContext.setJob(domain);
    }
}
