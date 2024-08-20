package com.customers.customer.controller;

import com.customers.customer.converter.DtoConverter;
import com.customers.customer.dto.CustomerDto;
import com.customers.customer.model.Customer;
import com.customers.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
//    CustomerDto customerDto;
    DtoConverter converter;
    CustomerService customerService;

    public CustomerController(DtoConverter converter, CustomerService customerService) {
        this.converter = converter;
        this.customerService = customerService;
    }

    //    CustomerService customerService;
    @PostMapping
    public ResponseEntity<CustomerDto> createBook(@RequestBody CustomerDto customerDto){
        Customer customer=converter.toEntity(customerDto);
        customer= customerService.createBook(customer);
        var responsebody=converter.toDto(customer);
        return ResponseEntity.ok().body(responsebody);
    }
    @GetMapping("/{id}")
    public  Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }
    @PutMapping("{id}")
    public CustomerDto updateById(@PathVariable Long id,@RequestBody CustomerDto customerDto){
        Customer customer=converter.toEntity(customerDto);

        customer=customerService.updateById(id,customer);
        return converter.toDto(customer);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        customerService.deleteById(id);
    }

}
