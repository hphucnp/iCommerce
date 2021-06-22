package com.phuc.icommerce.business.product;


import com.phuc.icommerce.data.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ProductService {
    Product findById(Long id);
//    Product add(Product product);
    Page<Product> getList(Map<String, String[]> filters, Pageable pageable);
//    Product update(Product product);
}

