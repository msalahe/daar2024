package org.ms.java.controllers;

import org.ms.java.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookSearchController {

	private BookService bookService;

	public BookSearchController(BookService bookService) {
		this.bookService = bookService;
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
	public String kmp(@RequestParam(name = "kmp") String kmp) {
		this.bookService.findbyKeyword(kmp);
		return kmp;
	}


}
