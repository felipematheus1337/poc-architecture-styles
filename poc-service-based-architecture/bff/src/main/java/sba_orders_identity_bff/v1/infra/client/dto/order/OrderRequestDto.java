package sba_orders_identity_bff.v1.infra.client.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {

    private String status;
    private BigDecimal total;
    private List<OrderItemsDto> items;
}
