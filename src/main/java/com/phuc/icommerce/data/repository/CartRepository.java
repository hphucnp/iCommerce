package com.phuc.icommerce.data.repository;

import com.phuc.icommerce.data.entity.user.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}