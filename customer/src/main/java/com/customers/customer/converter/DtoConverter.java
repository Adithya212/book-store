package com.customers.customer.converter;

import com.customers.customer.dto.CustomerDto;
import com.customers.customer.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {
    public CustomerDto toDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }

    // Convert CustomerDto to Customer
    public static Customer toEntity(CustomerDto customerDto) {
        if (customerDto == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(customerDto.id());
        customer.setName(customerDto.name());
        customer.setEmail(customerDto.email());
        customer.setPhoneNumber(customerDto.phoneNumber());
        return customer;
    }
}
