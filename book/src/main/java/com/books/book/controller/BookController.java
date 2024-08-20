package com.books.book.controller;

import com.books.book.converter.DtoConverter;
import com.books.book.dto.BookDto;
import com.books.book.model.Book;
import com.books.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    BookService bookService;
    DtoConverter converter;

    public BookController(BookService bookService, DtoConverter converter) {
        this.bookService = bookService;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        Book book=converter.toEntity(bookDto);
        book= bookService.createBook(book);
        var responsebody=converter.toDto(book);
       return ResponseEntity.ok().body(responsebody);
    }

    @GetMapping("/{id}")
    public  Book getBookById(@PathVariable long id){
        return  bookService.getBookById(id);
    }
    @PutMapping("{id}")
    public BookDto updateById(@PathVariable Long id,@RequestBody BookDto bookDto){
        Book book=converter.toEntity(bookDto);

        book=bookService.updateById(id,book);
        return converter.toDto(book);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        bookService.deleteById(id);
    }

}
