package com.orders.order.client;

import com.orders.order.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@FeignClient(name = "book")
public interface BookClient {

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable long id);

}
