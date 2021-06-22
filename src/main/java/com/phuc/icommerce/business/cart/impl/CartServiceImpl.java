package com.phuc.icommerce.business.cart.impl;

import com.phuc.icommerce.business.cart.CartService;
import com.phuc.icommerce.business.product.ProductService;
import com.phuc.icommerce.data.entity.composite.CartProduct;
import com.phuc.icommerce.data.entity.composite.CartProductKey;
import com.phuc.icommerce.data.entity.product.Product;
import com.phuc.icommerce.data.entity.user.Cart;
import com.phuc.icommerce.data.repository.CartProductRepository;
import com.phuc.icommerce.data.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;
    private final ProductService productService;


    @Override
    @Transactional
    public Cart addProduct(Long cartId, Long productId) throws Exception {
        try {
            Cart cart = get(cartId);
            Product product = productService.findById(productId);
            CartProductKey key = new CartProductKey(cartId, productId);
            Optional<CartProduct> optionalCartProduct = this.cartProductRepository.findById(key);
            if (optionalCartProduct.isEmpty()) {
                CartProduct newCartProduct = new CartProduct();
                newCartProduct.setId(key);
                newCartProduct.setProduct(product);
                newCartProduct.setCart(cart);
                newCartProduct.setQuantity(1);
                this.cartProductRepository.save(newCartProduct);
            } else {
                CartProduct cartProduct = optionalCartProduct.get();
                cartProduct.setQuantity(cartProduct.getQuantity() + 1);
                this.cartProductRepository.save(cartProduct);
            }
            return this.get(cartId);
        }
        catch (Exception exception) {
            throw new Exception(exception);
        }
    }

    @Override
    public Cart get(Long cartId) throws Exception {
            Cart cart = cartRepository.findById(cartId).orElse(null);
            if (cart == null) throw new Exception("Cannot find the cart id " + cartId);
            return cart;
    }
}
