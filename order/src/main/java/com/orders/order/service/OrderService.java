package com.orders.order.service;

import com.orders.order.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrder();
    Order getOrderById(Long id);
    void deleteById(Long id);
    Order updateById(Long id,Order order);
}

