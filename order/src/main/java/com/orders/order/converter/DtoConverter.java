package com.orders.order.converter;

import com.orders.order.dto.OrderDto;
import com.orders.order.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {
    public Order toEntity(OrderDto orderDto){
        return new Order(orderDto.id(), orderDto.customerId(), orderDto.bookId(), orderDto.quantity(), orderDto.status());
    }
    public OrderDto toDto(Order order){
        return new OrderDto(order.getId(), order.getCustomerId(), order.getBookId(), order.getQuantity(), order.getStatus());
    }
}
