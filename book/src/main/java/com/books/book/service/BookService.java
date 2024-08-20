package com.books.book.service;

import com.books.book.dto.BookDto;
import com.books.book.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createBook(Book book);
    List<Book> getAllBook();
    Book getBookById(Long id);
    void deleteById(Long id);
    Book updateById(Long id,Book book);
}
