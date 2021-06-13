package com.phuc.icommerce.data.entity.product;

import com.phuc.icommerce.data.entity.composite.CartProduct;
import com.phuc.icommerce.data.entity.composite.OrderProduct;
import com.phuc.icommerce.data.entity.order.Order;
import com.phuc.icommerce.data.entity.user.Cart;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Positive
    private BigDecimal price;

    @JoinColumn
    @ManyToOne
    private Category category;

    @JoinColumn
    @ManyToOne
    private Brand brand;


    @JoinColumn
    @ManyToOne
    private Order order;

    @JoinColumn
    @ManyToOne
    private Cart cart;

    private Color color;

    @OneToMany(mappedBy = "product")
    Set<CartProduct> cartProducts;

    @OneToMany(mappedBy = "product")
    Set<OrderProduct> orderProducts;
}
