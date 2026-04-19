package com.thinkconstructive.bookstore.dto;

public record BookDto(String bookID, String name, 
                    double price, String author, String description) {

}
