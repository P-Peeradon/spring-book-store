package com.thinkconstructive.bookstore.entity;

public record Book(String bookID, String name, 
                    double price, String author, String description) 
{

}
