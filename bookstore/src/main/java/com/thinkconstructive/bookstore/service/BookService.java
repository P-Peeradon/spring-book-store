package com.thinkconstructive.bookstore.service;

import java.util.List;

import com.thinkconstructive.bookstore.dto.BookDto;

public interface BookService 
{

    public BookDto getBook(String bookID);

    public List<BookDto> getAllBooks();

    public BookDto createBook(BookDto bookDto);
    
    public BookDto updateBook(BookDto bookDto);
    
    public void deleteBookByID(String bookID);
}
