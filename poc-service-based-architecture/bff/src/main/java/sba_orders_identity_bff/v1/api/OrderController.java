package sba_orders_identity_bff.v1.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sba_orders_identity_bff.v1.application.OrderService;
import sba_orders_identity_bff.v1.domain.OrderResponseWrapper;
import sba_orders_identity_bff.v1.infra.client.dto.order.OrderDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public ResponseEntity<OrderResponseWrapper> create(@RequestBody OrderDto dto) {
        return orderService.create(dto);
    }
}
