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

    @EmbeddedId
    CartProductKey id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    Cart cart;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    private int quantity;

}