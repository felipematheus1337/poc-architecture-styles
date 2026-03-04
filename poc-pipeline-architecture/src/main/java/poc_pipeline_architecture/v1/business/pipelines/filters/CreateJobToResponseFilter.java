package poc_pipeline_architecture.v1.business.pipelines.filters;

import org.springframework.stereotype.Component;
import poc_pipeline_architecture.v1.business.mapper.JobMapper;
import poc_pipeline_architecture.v1.business.pipelines.context.CreateJobContext;
import poc_pipeline_architecture.v1.presentation.dtos.JobResponse;

@Component
public class CreateJobToResponseFilter implements Filter<CreateJobContext>{

    private final JobMapper mapper;

    public CreateJobToResponseFilter(JobMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void apply(CreateJobContext tContext) {
        JobResponse response = mapper.toResponse(tContext.job);
        tContext.setResponse(response);

    }
}
