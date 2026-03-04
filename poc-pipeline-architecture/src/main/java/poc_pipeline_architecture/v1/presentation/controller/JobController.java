package poc_pipeline_architecture.v1.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc_pipeline_architecture.v1.business.JobService;
import poc_pipeline_architecture.v1.presentation.dtos.JobRequest;
import poc_pipeline_architecture.v1.presentation.dtos.JobResponse;


import java.util.List;

@RestController
@RequestMapping("/v1/jobs")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<JobResponse> createJob(@RequestBody JobRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createJob(request));

    }

    @PostMapping("/{id}/start")
    public ResponseEntity<JobResponse> startAnJob(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(service.startAJob(id));

    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponse> getAnJob(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.getAJob(id));
    }

    @GetMapping
    public ResponseEntity<List<JobResponse>> listJobs() {

        return ResponseEntity.ok(service.list());

    }
}
