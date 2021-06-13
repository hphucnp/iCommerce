package com.phuc.icommerce.data.repository;

import com.phuc.icommerce.data.entity.product.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}