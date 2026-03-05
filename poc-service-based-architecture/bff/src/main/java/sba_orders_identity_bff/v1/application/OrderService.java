package sba_orders_identity_bff.v1.application;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sba_orders_identity_bff.v1.domain.OrderResponseWrapper;
import sba_orders_identity_bff.v1.infra.client.OrderClient;
import sba_orders_identity_bff.v1.infra.client.dto.order.OrderDto;
import sba_orders_identity_bff.v1.infra.client.dto.order.OrderRequestDto;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderClient orderServiceClient;

    public ResponseEntity<OrderResponseWrapper> create(OrderDto dto) {
        OrderRequestDto request = OrderRequestDto
                .builder()
                .items(dto.getItems())
                .total(dto.getTotal())
                .status(dto.getStatus())
                .build();
        var response =  orderServiceClient.createOrder(request);

        return ResponseEntity.ok(
                OrderResponseWrapper
                        .builder()
                        .code(HttpStatus.OK.value())
                        .message("Sucessfully")
                        .payload(response.getPayload())
                        .build());
    }
}
