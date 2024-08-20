package com.customers.customer.service;

import com.customers.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createBook(Customer customer);
    List<Customer> getAllBook();
    Customer getCustomerById(Long id);
    void deleteById(Long id);
    Customer updateById(Long id,Customer customer);
}

