package sba_orders_identity_bff.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sba_orders_identity_bff.v1.infra.client.dto.order.OrderDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseWrapper {

    private String message;
    private Integer code;
    private OrderDto payload;
}
