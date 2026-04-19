package com.thinkconstructive.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.thinkconstructive.bookstore.entity.Book;

public interface BookRepository extends MongoRepository<Book, String> 
{
    @Query("{bookID: '?0'}")
    Book findByID(String bookID);

    @Query("{bookID: '?0'}")
    void updateNameByID(String bookID, String name);
}
