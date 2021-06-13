package com.phuc.icommerce.business.order;

import com.phuc.icommerce.data.entity.order.Order;
import com.phuc.icommerce.data.entity.product.Product;

import java.util.List;
import java.util.Map;

public interface OrderService {
//    Order findById(Long id);
    Order createOrder(Order order);
    Order addProduct(Long orderId, Product product);
    Order removeProduct(Long orderId, Product product);
//    List<Order> getList(Map<String, String> filters);
}
