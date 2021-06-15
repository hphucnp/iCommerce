package com.phuc.icommerce.data.repository;

import com.phuc.icommerce.data.entity.composite.CartProduct;
import com.phuc.icommerce.data.entity.composite.CartProductKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, CartProductKey> {
}