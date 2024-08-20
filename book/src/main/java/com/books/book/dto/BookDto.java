package com.books.book.dto;

import jakarta.validation.constraints.NotEmpty;

public record BookDto(
    Long id,
    @NotEmpty
    String title,
    String author,
    Long price,
    Integer stock
) {
}
