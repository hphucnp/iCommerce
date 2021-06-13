package com.phuc.icommerce.business.order.impl;

import com.phuc.icommerce.business.order.OrderService;
import com.phuc.icommerce.data.entity.order.Order;
import com.phuc.icommerce.data.entity.product.Product;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order addProduct(Long orderId, Product product) {
        return null;
    }

    @Override
    public Order removeProduct(Long orderId, Product product) {
        return null;
    }
}
