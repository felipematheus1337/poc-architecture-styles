package sba_orders_identity_bff.v1.infra.client;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sba_orders_identity_bff.v1.infra.client.dto.ResponseDto;
import sba_orders_identity_bff.v1.infra.client.dto.order.OrderDto;
import sba_orders_identity_bff.v1.infra.client.dto.order.OrderRequestDto;

@FeignClient(
        name = "order-service-client",
        url = "${services.order.url}"
)
public interface OrderServiceClient {

    @Headers({ "Content-Type: application/json"})
    @PostMapping
    ResponseDto<OrderDto> createOrder(
            @RequestBody OrderRequestDto requestDto
    );
}
