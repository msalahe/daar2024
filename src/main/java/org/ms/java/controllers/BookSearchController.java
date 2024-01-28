package org.ms.java.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.ms.java.dao.BookRepository;
import org.ms.java.helper.regex.DataInitializer;
import org.ms.java.models.Books;
import org.ms.java.models.Document;

import org.ms.java.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookSearchController {

	private BookService bookService;
	private BookRepository bookRepository;
	

	public BookSearchController(BookService bookService,BookRepository bookRepository) {
		this.bookService = bookService;
		this.bookRepository = bookRepository;
		
	}

	@GetMapping("/test")
	public String getTest() {
		return "TEST";
	}

	@GetMapping("/regex")
	public String searchByRegex(@RequestParam(name = "regex") String regex) {
		this.bookService.findByRegex(regex);
		return regex;
	}
	
	@GetMapping("/kmp")
	public List<Document> kmp(@RequestParam(name = "kmp") String kmp) {
		return this.bookService.findbyKeyword(kmp);
	}
	
	@GetMapping("/book")
	public List<Books> book() {
		
		return bookRepository.books();
		
		
	}


}
