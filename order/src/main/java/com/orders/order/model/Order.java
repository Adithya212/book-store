package com.orders.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@AllArgsConstructor@NoArgsConstructor@Getter
@Entity
@Table(name = "my_orders")
public class Order {
    @Id
    @GeneratedValue
    private  Long id;
    private Long customerId;
    private Long bookId;
    private Integer quantity;
    private String status;
}
