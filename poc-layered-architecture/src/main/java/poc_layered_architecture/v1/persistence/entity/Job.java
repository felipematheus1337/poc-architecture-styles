package poc_layered_architecture.v1.persistence.entity;


import jakarta.persistence.*;
import poc_layered_architecture.v1.persistence.entity.enums.JobStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private JobStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;

    @OneToMany(mappedBy = "jobs")
    private List<StepExecution> steps;

    public Job() {
    }

    public Job(Long id, String name, JobStatus status, LocalDateTime createdAt, LocalDateTime startedAt, LocalDateTime finishedAt, List<StepExecution> steps) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.steps = steps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    public List<StepExecution> getSteps() {

        if (steps == null) steps = new ArrayList<>();

        return steps;
    }

    public void setSteps(List<StepExecution> steps) {
        this.steps = steps;
    }
}
