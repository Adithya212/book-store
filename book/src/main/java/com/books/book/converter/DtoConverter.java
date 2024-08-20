package com.books.book.converter;

import com.books.book.dto.BookDto;
import com.books.book.model.Book;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {
    public Book toEntity(BookDto bookDto){
        Book book =new Book();
        return  new Book(bookDto.id(),bookDto.title(),bookDto.author(),bookDto.price(),bookDto.stock());
//        book.setId(bookDto.id());
//        book.setTitle(bookDto.title());
//        book.setAuthor(bookDto.author());
//        book.setPrice(bookDto.price());
//        book.setStock(bookDto.stock());
//        return book;
    }
    public BookDto toDto(Book book){
        return  new BookDto(book.getId(), book.getTitle(), book.getAuthor(),book.getPrice(),book.getStock());
    }


}
