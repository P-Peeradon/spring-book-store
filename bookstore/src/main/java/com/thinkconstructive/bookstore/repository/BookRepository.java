package com.thinkconstructive.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.mongodb.repository.DeleteQuery;

import com.thinkconstructive.bookstore.entity.Book;

public interface BookRepository extends MongoRepository<Book, String> 
{
    @Query("{bookID: '?0'}")
    Book findByID(String bookID);

    @Query(value = "{ 'bookID' : {$eq: ?0} }")
    @Update(pipeline = { " { '$set': {'name': ?1} }"})
    void updateNameByID(String bookID, String name);

    @DeleteQuery
    void deleteByBookID(String BookID);
}
