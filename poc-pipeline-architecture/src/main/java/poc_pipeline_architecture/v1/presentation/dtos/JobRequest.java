package poc_pipeline_architecture.v1.presentation.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record JobRequest(@NotBlank String name, List<StepExecutionRequest> steps) {
}
