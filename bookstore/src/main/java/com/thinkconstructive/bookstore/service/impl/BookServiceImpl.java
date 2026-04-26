package com.thinkconstructive.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.thinkconstructive.bookstore.dto.BookDto;
import com.thinkconstructive.bookstore.entity.Book;
import com.thinkconstructive.bookstore.mapper.BookMapper;
import com.thinkconstructive.bookstore.repository.BookRepository;
import com.thinkconstructive.bookstore.service.BookService;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService 
{

    BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) 
    {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto getBook(String bookID) 
    {
        Book book = bookRepository.findByID(bookID);
        BookDto bookDto = BookMapper.toDto(book);
        return bookDto;
    }

    @Override
    public List<BookDto> getAllBooks() 
    {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        
        for (Book book: books) 
        {
            bookDtoList.add(BookMapper.toDto(book));
        }

        return bookDtoList;
    }

    @Override
    public BookDto createBook(BookDto bookDto) 
    {
        Book book = bookRepository.insert(BookMapper.toEntity(bookDto));
        return BookMapper.toDto(book);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        bookRepository.updateNameByID(bookDto.bookID(), bookDto.name());
        Book book = bookRepository.findByID(bookDto.bookID());
        return BookMapper.toDto(book);
    }

    @Override
    public void deleteBookByID(String bookID) {
        bookRepository.deleteByBookID(bookID);
    }

}
