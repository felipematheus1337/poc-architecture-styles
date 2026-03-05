package orders_service.v1.infra.dtos;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record OrderResponse(Long id, String status, BigDecimal total, LocalDateTime createdAt, List<OrderItemsResponse> items) {
}
