package com.customers.customer.dto;

public record CustomerDto(
        Long id,
        String name,
        String email,
        String phoneNumber
) {
}
