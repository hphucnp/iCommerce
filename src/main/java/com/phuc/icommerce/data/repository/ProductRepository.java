package com.phuc.icommerce.data.repository;

import com.phuc.icommerce.data.entity.product.Product;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, QuerydslPredicateExecutor<Product> {
}