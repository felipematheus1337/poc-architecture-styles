package orders_service.v1.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItens {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private OrderEntity order;

    private String sku;

    @Column(name = "qty")
    private Integer quantity;

    private BigDecimal price;

}
