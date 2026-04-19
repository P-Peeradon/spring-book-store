package com.thinkconstructive.bookstore.dto;

public record BookDto(String bookId, String name, 
                    double price, String author, String description) {

}
