package com.thinkconstructive.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testName() {
        
    }

    @BeforeEach
    void setUp() {
        
    }

    @AfterEach
    void tearDown() {
        
    }

    @Test
    void testGetAllBooks() {
        
    }

    @Test
    void testGetBook() {
        
    }

    @Test
    void testCreateBook() {
        
    }

    @Test
    void testUpdateBook() {
        
    }

    @Test
    void testDeleteBook() {
        
    }
    
}
