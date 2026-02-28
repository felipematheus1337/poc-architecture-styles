package poc_layered_architecture.v1.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc_layered_architecture.v1.presentation.dtos.JobRequest;
import poc_layered_architecture.v1.presentation.dtos.JobResponse;

@RestController
@RequestMapping("/v1/jobs")
public class JobController {


    @PostMapping
    public ResponseEntity<JobResponse> createJob(@RequestBody JobRequest request) {

    }

    @PostMapping("/{id}/start")
    public ResponseEntity<JobResponse> startAnJob(@PathVariable(name = "id") Long id) {

    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponse> getAnJob(@PathVariable(name = "id") Long id) {

    }

    @GetMapping
    public ResponseEntity<List<JobResponse>> listJobs() {

    }
}
