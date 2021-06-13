package com.phuc.icommerce.data.repository;

import com.phuc.icommerce.data.entity.order.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
}