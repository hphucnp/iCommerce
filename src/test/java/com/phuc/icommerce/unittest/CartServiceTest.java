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
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
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
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartProductRepository cartProductRepository;
    @Autowired
    UserRepository userRepository;



    @SneakyThrows
    @Sql(scripts = {"classpath:icommerce-schema-test.sql", "classpath:icommerce-data-test.sql"},
            config = @SqlConfig(encoding = "utf-8"),
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    void addition() {
        Long cartId=1L, productId=1L;
        cartService.addProduct(productId, cartId);
        assertEquals(1L, cartProductRepository.getById(new CartProductKey(cartId, productId)).getQuantity());
        cartService.addProduct(productId, cartId);
        assertEquals(2L, cartProductRepository.getById(new CartProductKey(cartId, productId)).getQuantity());
    }
}
