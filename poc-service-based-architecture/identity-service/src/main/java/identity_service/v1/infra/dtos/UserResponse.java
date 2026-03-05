package identity_service.v1.infra.dtos;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserResponse(Long id, String name, String email, LocalDateTime createdAt) {
}
