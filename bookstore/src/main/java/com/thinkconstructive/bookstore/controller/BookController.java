package com.thinkconstructive.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/book-store")
public class BookController {

    @Autowired
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookID}")
    public ResponseEntity<BookDto> getBook(@PathVariable String bookID) {
        BookDto bookDto = bookService.getBook(bookID);
        // ResponseEntity<>(body, status) HTTP
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        BookDto bookDto1 = bookService.createBook(bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) {
        BookDto bookDto1 = bookService.updateBook(bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);
    }

    @DeleteMapping("/{bookID}")
    public ResponseEntity<Void> deleteBook(@PathVariable String bookID) {
        bookService.deleteBookByID(bookID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
