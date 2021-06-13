package com.phuc.icommerce.business.product.impl;

import com.phuc.icommerce.business.product.ProductService;
import com.phuc.icommerce.data.entity.product.Product;
import com.phuc.icommerce.data.entity.product.QProduct;
import com.phuc.icommerce.data.repository.ProductRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product findById(Long id) {
            return productRepository.findById(id).orElseThrow(() -> {
                try {
                    throw new Exception("Cannot find the product id " + id);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                return null;
            });
    }

    @Override
    public Page<Product> getList(Map<String, String> filters, Pageable pageable) {
        QProduct qProduct = QProduct.product;
        BooleanExpression expression = Expressions.asBoolean(true).isTrue();
        if(!filters.isEmpty()){
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                BooleanExpression condition = null;
                switch (key) {
                    case "brand":
                        condition = qProduct.brand.name.containsIgnoreCase(value);
                        break;
                    case "category":
                        condition = qProduct.category.name.containsIgnoreCase(value);
                        break;
                    case "startPrice":
                        condition = qProduct.price.goe(new BigDecimal(value));
                        break;
                    case "endPrice":
                        condition = qProduct.price.loe(new BigDecimal(value));
                }
                if (condition != null) {
                    expression = expression.and(condition);
                }
            }
        }
        return productRepository.findAll(expression, pageable);
    }

//    @Override
//    @Transactional
//    public Product add(Product product) {
//        return this.productRepository.save(product);
//    }



//    @Override
//    public Product update(Product product) {
//        return null;
//    }
}
