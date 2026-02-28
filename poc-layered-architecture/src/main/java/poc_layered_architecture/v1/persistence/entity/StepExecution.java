package poc_layered_architecture.v1.persistence.entity;

import jakarta.persistence.*;
import poc_layered_architecture.v1.persistence.entity.enums.StepStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "step_execution")
public class StepExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stepName;

    private Integer order;

    private StepStatus status;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;

    public StepExecution() {
    }

    public StepExecution(Long id, String stepName, Integer order, StepStatus status, LocalDateTime startedAt, LocalDateTime finishedAt) {
        this.id = id;
        this.stepName = stepName;
        this.order = order;
        this.status = status;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public StepStatus getStatus() {
        return status;
    }

    public void setStatus(StepStatus status) {
        this.status = status;
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
}
