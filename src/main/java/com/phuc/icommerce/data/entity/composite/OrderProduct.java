package com.phuc.icommerce.data.entity.composite;

import com.phuc.icommerce.data.entity.order.Order;
import com.phuc.icommerce.data.entity.product.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "order_product")
@Data
@Entity
public class OrderProduct {
    @Embeddable
    @Setter
    @Getter
    class OrderProductKey implements Serializable {

        @Column(name = "order_id")
        Long orderId;

        @Column(name = "product_id")
        Long productId;
    }

    @EmbeddedId
    OrderProductKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    private int quantity;

}