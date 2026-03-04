package poc_pipeline_architecture.v1.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record JobRequest(@NotBlank String name, @NotEmpty List<StepExecutionRequest> steps) {
}
