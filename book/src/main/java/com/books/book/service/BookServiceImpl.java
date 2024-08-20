package com.books.book.service;

import com.books.book.model.Book;
import com.books.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class BookServiceImpl implements BookService {
    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public Book updateById(Long id,Book book) {
        Book updatedbook = bookRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Book not found"));

            updatedbook.setTitle(book.getTitle());
            updatedbook.setAuthor(book.getAuthor());
            updatedbook.setPrice(book.getPrice());
            updatedbook.setStock(book.getStock());
            return bookRepository.save(updatedbook);
    }



}
