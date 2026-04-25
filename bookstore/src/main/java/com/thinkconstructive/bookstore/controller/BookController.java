package com.thinkconstructive.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkconstructive.bookstore.dto.BookDto;
import com.thinkconstructive.bookstore.service.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/book-store")
public class BookController {
    
    BookService bookService;

    public BookController(BookService bookService) 
    {
        this.bookService = bookService;
    }

    @GetMapping("/{bookID}")    
    public ResponseEntity<BookDto> getBook(@PathVariable String bookID) 
    {
        BookDto bookDto = bookService.getBook(bookID);
        // ResponseEntity<>(body, status) HTTP
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<String>> getAllBooks() 
    {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("MongoDB");
        books.add("Spring Boot");

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> createBook(String book)
    {
        return new ResponseEntity<>("Book Created", HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateBook(String book) 
    {
        
        
        return new ResponseEntity<>("Book Updated", HttpStatus.OK);
    }

    @DeleteMapping("/{bookID}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookID) 
    {
        return new ResponseEntity<>("Book Deleted Successfully", HttpStatus.OK);
    }
}
