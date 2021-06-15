package com.phuc.icommerce.data.entity.composite;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@RequiredArgsConstructor
public class CartProductKey implements Serializable {

    @Column(name = "cart_id")
    Long cartId;

    @Column(name = "product_id")
    Long productId;

    public CartProductKey(Long cartId, Long productId) {
        this.cartId = cartId;
        this.productId = productId;
    }
}