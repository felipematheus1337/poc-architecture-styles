package orders_service.v1.infra.builder;

import lombok.AllArgsConstructor;
import orders_service.v1.domain.model.OrderEntity;
import orders_service.v1.domain.model.OrderItens;
import orders_service.v1.domain.model.enums.OrderStatus;
import orders_service.v1.infra.dtos.OrderItemsResponse;
import orders_service.v1.infra.dtos.OrderRequest;
import orders_service.v1.infra.dtos.OrderResponse;
import orders_service.v1.infra.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OrderBuilder {

    private final OrderRepository orderEntityRepository;

    public OrderEntity toOrder(OrderRequest request) {
        return OrderEntity
                .builder()
                .total(request.total())
                .status(OrderStatus.valueOf(request.status()))
                .itens(toItensList(request.items()))
                .build();
    }

    public OrderResponse toResponse(OrderEntity order) {

        return OrderResponse
                .builder()
                .total(order.getTotal())
                .status(order.getStatus().toString())
                .items(toItensResponse(order.getItens()))
                .build();
    }

    public List<OrderItens> toItensList(List<OrderItemsResponse> itens) {

        return itens
                .stream()
                .map(this::toOrderItensResponse)
                .toList();

    }

    public List<OrderItemsResponse> toItensResponse(List<OrderItens> itens) {
        return itens
                .stream()
                .map(this::toOrderItens)
                .toList();
    }

    public OrderItemsResponse toOrderItens(OrderItens orderItens) {
        return OrderItemsResponse
                .builder()
                .orderId(orderItens.getOrder().getId())
                .sku(orderItens.getSku())
                .price(orderItens.getPrice())
                .qty(orderItens.getQuantity())
                .build();
    }

    public OrderItens toOrderItensResponse(OrderItemsResponse response) {
        return OrderItens
                .builder()
                .order(getOrder(response.orderId()))
                .sku(response.sku())
                .price(response.price())
                .id(response.id())
                .quantity(response.qty())
                .build();
    }

    private OrderEntity getOrder(Long orderId) {
        return orderEntityRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException());
    }
}
