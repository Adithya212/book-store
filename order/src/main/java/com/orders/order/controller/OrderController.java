package com.orders.order.controller;

import com.orders.order.client.BookClient;
import com.orders.order.converter.DtoConverter;
import com.orders.order.dto.OrderDto;
import com.orders.order.model.Order;
import com.orders.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    DtoConverter dtoConverter;
    @Autowired
    OrderService orderService;
//    BookClient bookClient;

    public OrderController(DtoConverter dtoConverter) {
        this.dtoConverter = dtoConverter;
    }


//    public OrderController(DtoConverter dtoConverter, OrderService orderService) {
//        this.dtoConverter = dtoConverter;
//        this.orderService = orderService;
//    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
        Order order=dtoConverter.toEntity(orderDto);
//        var id=order.getBookId();

        order =orderService.createOrder(order);
        var res=dtoConverter.toDto(order);
        return ResponseEntity.ok().body(res);
    }
    @GetMapping
    public List<Order> getOrder(){
//        Order order=dtoConverter.toEntity(orderDto);
        return orderService.getAllOrder();
//        return dtoConverter.toDto(order);

}}


