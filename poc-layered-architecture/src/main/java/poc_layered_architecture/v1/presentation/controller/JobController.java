package poc_layered_architecture.v1.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/jobs")
public class JobController {


    @PostMapping
    public ResponseEntity<?> createJob(@RequestBody JobRequest request) {

    }

    @PostMapping("/{id}/start")
    public ResponseEntity<?> startAnJob(@PathVariable(name = "id") Long id) {

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnJob(@PathVariable(name = "id") Long id) {

    }

    @GetMapping
    public ResponseEntity<?> listJobs() {

    }
}
