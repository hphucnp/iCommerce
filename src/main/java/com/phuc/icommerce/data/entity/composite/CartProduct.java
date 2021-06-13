package com.phuc.icommerce.data.entity.composite;

import com.phuc.icommerce.data.entity.product.Product;
import com.phuc.icommerce.data.entity.user.Cart;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "cart_product")
@Data
@Entity
public class CartProduct {
    @Embeddable
    @Setter
    @Getter
    class CartProductKey implements Serializable {

        @Column(name = "cart_id")
        Long cartId;

        @Column(name = "product_id")
        Long productId;
    }

    @EmbeddedId
    CartProductKey id;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    Cart cart;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    private int quantity;

}