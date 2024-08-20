package com.orders.order.dto;

public record OrderDto(
        Long id,Long customerId,Long bookId,Integer quantity,String status
) {
}
