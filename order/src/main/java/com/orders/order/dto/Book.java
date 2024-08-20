package com.orders.order.dto;

public class Book {
    private Long id;
    private String title;
    private String author;
    private  Long price;
    private Integer stock;

    public int getStock() {
        return stock;
    }
}
