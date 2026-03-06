package poc_broker_topology.v1.infra.dtos;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record NoteResponseDto(Long id, String title, String content, LocalDateTime createdAt) {
}
