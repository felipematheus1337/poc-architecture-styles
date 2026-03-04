package poc_pipeline_architecture.v1.business.pipelines.context;

import poc_pipeline_architecture.v1.business.command.CreateJobCommand;
import poc_pipeline_architecture.v1.persistence.entity.Job;
import poc_pipeline_architecture.v1.presentation.dtos.JobRequest;
import poc_pipeline_architecture.v1.presentation.dtos.JobResponse;

public class CreateJobContext {
    public JobRequest request;
    public JobResponse response;
    public Job job;
    public CreateJobCommand command;

    public CreateJobContext(JobRequest request) {
        this.request = request;
    }
}
