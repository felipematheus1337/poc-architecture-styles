package poc_pipeline_architecture.v1.business.pipelines.context;

import poc_pipeline_architecture.v1.persistence.entity.Job;
import poc_pipeline_architecture.v1.presentation.dtos.JobRequest;
import poc_pipeline_architecture.v1.presentation.dtos.JobResponse;

public class CreateJobContext implements Context {
    public JobRequest request;
    public JobResponse response;
    public Job job;

    public CreateJobContext(JobRequest request) {
        this.request = request;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setResponse(JobResponse response) {
        this.response = response;
    }
}
