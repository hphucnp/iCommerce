package com.phuc.icommerce.data.entity.order;

import com.phuc.icommerce.data.entity.composite.OrderProduct;
import com.phuc.icommerce.data.entity.user.Cart;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Table(name = "orders")
@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne

    private Cart cart;

    private Status status;

    @OneToMany(mappedBy = "order")
    Set<OrderProduct> orderProducts;

}