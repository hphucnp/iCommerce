package com.phuc.icommerce.api.controller;

import com.phuc.icommerce.api.response.BrandRequest;
import com.phuc.icommerce.api.response.BrandResponse;
import com.phuc.icommerce.api.response.CartResponse;
import com.phuc.icommerce.business.brand.BrandService;
import com.phuc.icommerce.business.cart.CartService;
import com.phuc.icommerce.data.entity.composite.CartProduct;
import com.phuc.icommerce.data.entity.product.Brand;
import com.phuc.icommerce.data.entity.user.Cart;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/cart", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Cart Rest API", description = "Cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping(value = "/{cartId}/{productId}")
    public CartResponse addProduct(@PathVariable Long cartId, @PathVariable Long productId) {
        try {
            Cart cart = this.cartService.addProduct(cartId, productId);
            return CartResponse.fromEntity(cart);
        }
        catch (Exception exception) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
}
