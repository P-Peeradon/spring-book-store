package com.thinkconstructive.bookstore.entity;

public record Book(String bookId, String name, 
                    double price, String author, String description) 
{
    
}
