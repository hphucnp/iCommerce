package com.phuc.icommerce.unittest;

import com.phuc.icommerce.JpaConfig;
import com.phuc.icommerce.business.cart.CartService;
import com.phuc.icommerce.business.cart.impl.CartServiceImpl;
import com.phuc.icommerce.business.product.ProductService;
import com.phuc.icommerce.business.product.impl.ProductServiceImpl;
import com.phuc.icommerce.data.entity.composite.CartProductKey;
import com.phuc.icommerce.data.entity.product.Product;
import com.phuc.icommerce.data.entity.user.Cart;
import com.phuc.icommerce.data.entity.user.User;
import com.phuc.icommerce.data.repository.CartProductRepository;
import com.phuc.icommerce.data.repository.CartRepository;
import com.phuc.icommerce.data.repository.ProductRepository;
import com.phuc.icommerce.data.repository.UserRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {JpaConfig.class, CartProductRepository.class,
        ProductRepository.class, CartRepository.class, UserRepository.class,
        CartServiceImpl.class, ProductServiceImpl.class})
@Transactional
@SpringBootTest
@EnableAutoConfiguration
class CartServiceTest {
    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;
    @Resource
    CartRepository cartRepository;
    @Resource
    ProductRepository productRepository;
    @Resource
    CartProductRepository cartProductRepository;
    @Resource
    UserRepository userRepository;



    @SneakyThrows
    @Test
    void addition() {
        Product product = new Product();
        Long productId = productRepository.save(product).getId();
        assertEquals(1L, productId);
        User user = new User();
        user = userRepository.save(user);
        Long userId = user.getId();
        assertEquals(1L, userId);
        Cart cart = new Cart();
        cart.setUser(user);
        Long cartId = cartRepository.save(cart).getId();
        assertEquals(1L, cartId);
        cartService.addProduct(productId, cartId);
        assertEquals(1L, cartProductRepository.getById(new CartProductKey(cartId, productId)).getQuantity());
        cartService.addProduct(productId, cartId);
        assertEquals(2L, cartProductRepository.getById(new CartProductKey(cartId, productId)).getQuantity());
    }
}
