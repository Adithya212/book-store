package com.customers.customer.service;

import com.customers.customer.model.Customer;
import com.customers.customer.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer createBook(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> getAllBook() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id).orElseThrow(()->new RuntimeException("NOt found"));
    }

    @Override
    public void deleteById(Long id) {
        customerRepo.deleteById(id);

    }

    @Override
    public Customer updateById(Long id, Customer customer) {
        Customer customer1=customerRepo.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        customer1.setId(customer.getId());
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        return customerRepo.save(customer1);

    }
}
