package orders_service.v1.infra.presentation;

import lombok.AllArgsConstructor;
import orders_service.v1.domain.service.OrderService;
import orders_service.v1.infra.dtos.OrderRequest;
import orders_service.v1.infra.dtos.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
