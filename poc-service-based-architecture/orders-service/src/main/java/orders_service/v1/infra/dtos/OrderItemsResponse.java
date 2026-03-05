package orders_service.v1.infra.dtos;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderItemsResponse(Long id, String sku, Integer qty, Long orderId, BigDecimal price) {
}
