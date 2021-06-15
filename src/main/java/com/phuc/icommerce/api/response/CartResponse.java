package com.phuc.icommerce.api.response;

import com.phuc.icommerce.data.entity.composite.CartProduct;
import com.phuc.icommerce.data.entity.product.Product;
import com.phuc.icommerce.data.entity.user.Cart;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Setter
@Getter
public class CartResponse {
    private Long id;
    private List<ProductResponse> products = new ArrayList<>();
    public static CartResponse fromEntity(Cart cart) {
        CartResponse cartResponse = new CartResponse();
        cartResponse.setId(cart.getId());
        List<ProductResponse> productResponses = cart.getCartProducts().stream().map(CartProduct::getProduct).filter(Objects::nonNull).map(ProductResponse::fromEntity).collect(Collectors.toList());
        cartResponse.setProducts(productResponses);
        return cartResponse;
    }
}
