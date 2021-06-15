package com.phuc.icommerce.business.cart.impl;

import com.phuc.icommerce.business.cart.CartService;
import com.phuc.icommerce.data.entity.composite.CartProduct;
import com.phuc.icommerce.data.entity.composite.CartProductKey;
import com.phuc.icommerce.data.entity.product.Product;
import com.phuc.icommerce.data.entity.user.Cart;
import com.phuc.icommerce.data.repository.CartProductRepository;
import com.phuc.icommerce.data.repository.CartRepository;
import com.phuc.icommerce.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;

    @Override
    @Transactional
    public Cart addProduct(Long cartId, Long productId) throws Exception {
        try {
            Cart cart = this.cartRepository.findById(cartId).orElse(null);

            if (cart == null) throw new Exception("Cannot find the cart id " + cartId);

            Product product = this.productRepository.findById(productId).orElse(null);

            if (product == null) throw new Exception("Cannot find the product id " + productId);
            CartProductKey key = new CartProductKey(cartId, productId);
            Optional<CartProduct> optionalCartProduct = this.cartProductRepository.findById(key);
            if (optionalCartProduct.isEmpty()) {
                CartProduct newCartProduct = new CartProduct();
                newCartProduct.setId(key);
                newCartProduct.setProduct(product);
                newCartProduct.setCart(cart);
                newCartProduct.setQuantity(0);
                this.cartProductRepository.save(newCartProduct);
            } else {
                CartProduct cartProduct = optionalCartProduct.get();
                cartProduct.setQuantity(cartProduct.getQuantity() + 1);
                this.cartProductRepository.save(cartProduct);
            }


            return this.cartRepository.findById(cartId).orElseThrow(() -> new Exception("seems not happen"));
        }
        catch (Exception exception) {
            throw new Exception(exception);
        }
    }
}
