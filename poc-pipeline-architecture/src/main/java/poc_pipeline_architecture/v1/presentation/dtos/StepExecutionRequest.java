package poc_layered_architecture.v1.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StepExecutionRequest(@NotBlank String name, @NotNull Integer order) {
}
