package orders_service.v1.infra.dtos;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderRequest(String status, BigDecimal total, List<OrderItemsResponse> items) {
}
