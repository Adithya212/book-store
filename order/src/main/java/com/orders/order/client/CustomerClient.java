package com.orders.order.client;


import com.orders.order.dto.Customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER")
public interface CustomerClient  {
    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable long id);
}
