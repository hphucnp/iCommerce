package com.phuc.icommerce.data.repository;

import com.phuc.icommerce.data.entity.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}