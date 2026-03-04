package poc_pipeline_architecture.v1.presentation.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record JobResponse(Long id, String name, String status,
                          LocalDateTime createdAt,
                          LocalDateTime startedAt,
                          LocalDateTime finishedAt,
List<StepExecutionResponse>steps) {
}
