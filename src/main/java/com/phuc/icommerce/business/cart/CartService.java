package com.phuc.icommerce.business.cart;

import com.phuc.icommerce.data.entity.user.Cart;

public interface CartService {
    Cart addProduct(Long cartId, Long productId) throws Exception;
}
