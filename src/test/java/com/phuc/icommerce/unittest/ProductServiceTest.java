package com.phuc.icommerce.unittest;

import com.phuc.icommerce.JpaConfig;
import com.phuc.icommerce.business.cart.impl.CartServiceImpl;
import com.phuc.icommerce.business.product.ProductService;
import com.phuc.icommerce.business.product.impl.ProductServiceImpl;
import com.phuc.icommerce.data.entity.product.Color;
import com.phuc.icommerce.data.entity.product.Product;
import com.phuc.icommerce.data.repository.CartProductRepository;
import com.phuc.icommerce.data.repository.CartRepository;
import com.phuc.icommerce.data.repository.ProductRepository;
import com.phuc.icommerce.data.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableAutoConfiguration
@SpringBootTest
@ContextConfiguration(classes = {JpaConfig.class, CartProductRepository.class,
        ProductRepository.class, CartRepository.class, UserRepository.class,
        CartServiceImpl.class, ProductServiceImpl.class})
public class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Resource
    ProductRepository productRepository;;

    @Test
    @Sql(scripts = {"classpath:icommerce-schema-test.sql", "classpath:icommerce-data-test.sql"},
            config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED))
    @BeforeAll
    static void start() {

    }

    @Test
    @Sql(scripts = {"classpath:icommerce-schema-test.sql", "classpath:icommerce-data-test.sql"},
            config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED),
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void testGet() {
        assertEquals("Pepsi Light", productService.findById(1L).getName());
    }

    @Test
    void testSearchingByBrand() {
        Map<String, String[]> filter = new HashMap<>() {{
            put("brand", new String[]{"Pepsi"});
        }};
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> products = productService.getList(filter, pageable);
        assertEquals(2, productService.getList(filter, pageable).toList().size());
        assertTrue(products.map(product -> product.getBrand().getName()).stream().allMatch((value) -> value.contains("Pepsi")));
    }

    @Test
    void testSearchingByCategory() {
        Map<String, String[]> filter = new HashMap<>() {{
            put("category", new String[]{"beverage"});
        }};
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> products = productService.getList(filter, pageable);
        assertEquals(2, productService.getList(filter, pageable).toList().size());
        assertTrue(products.map(product -> product.getCategory().getName()).stream().allMatch((value) -> value.contains("beverage")));
    }

    @Test
    void testSearchingByStartPrice() {
        Map<String, String[]> filter = new HashMap<>() {{
            put("startPrice", new String[]{"1000000"});
        }};
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> products = productService.getList(filter, pageable);
        assertEquals(1, productService.getList(filter, pageable).toList().size());
        assertTrue(products.map(Product::getPrice).stream().allMatch((value) -> value.compareTo(new BigDecimal("1000000")) > 0));
    }

    @Test
    void testSearchingByColor() {
        Map<String, String[]> filter = new HashMap<>() {{
            put("color", new String[]{"RED"});
        }};
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> products = productService.getList(filter, pageable);
        assertEquals(1, productService.getList(filter, pageable).toList().size());
        assertTrue(products.map(Product::getColor).stream().allMatch((value) -> value  == Color.RED));
    }


}
