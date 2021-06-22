package com.phuc.icommerce;

import com.phuc.icommerce.api.controller.CartController;
import com.phuc.icommerce.api.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IcommerceApplicationTests {

    @Autowired
    ProductController productController;

    @Autowired
    CartController cartController;

    @Test
    void contextLoads() {
//        Assertions.assertThat(productController).isNot(null);
//        Assertions.assertThat(cartController).isNot(null);
    }

}
