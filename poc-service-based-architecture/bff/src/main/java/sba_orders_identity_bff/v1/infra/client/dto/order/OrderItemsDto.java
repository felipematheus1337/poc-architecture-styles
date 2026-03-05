package sba_orders_identity_bff.v1.infra.client.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDto {

    private Long id;
    private String sku;
    private Integer qty;
    private Long orderId;
    private BigDecimal price;
}
