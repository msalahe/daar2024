package org.ms.java.helper.regex;

import java.util.List;

import org.ms.java.dao.BookRepository;
import org.ms.java.models.Books;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    
    private List<Books> books;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
    	System.out.println("sss");
       this.books = bookRepository.books();
       System.out.println(this.books.size());
    }

    // Method to retrieve the books
    public List<Books> getBooks() {
        return books;
    }
}