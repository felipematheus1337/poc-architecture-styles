package orders_service.v1.domain.service;

import lombok.AllArgsConstructor;
import orders_service.v1.domain.model.OrderEntity;
import orders_service.v1.infra.builder.OrderBuilder;
import orders_service.v1.infra.dtos.OrderRequest;
import orders_service.v1.infra.dtos.OrderResponse;
import orders_service.v1.infra.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderEntityRepository;
    private final OrderBuilder orderBuilder;

    @Transactional
    public OrderResponse create(OrderRequest request) {
        OrderEntity order = this.orderBuilder.toOrder(request);
        return this.orderBuilder.toResponse(orderEntityRepository.save(order));
    }

    public OrderResponse get(Long id) {
        return this.orderBuilder.toResponse(orderEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()));
    }


}
