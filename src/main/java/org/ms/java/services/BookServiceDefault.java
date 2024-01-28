package org.ms.java.services;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.ms.java.dao.BookEntityRepository;
import org.ms.java.helper.regex.KMP;
import org.ms.java.helper.regex.RegexToDfa;
import org.ms.java.models.Books;
import org.ms.java.models.Document;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class BookServiceDefault implements BookService{

	private RegexToDfa regexToDfa;
	private KMP kmP;
	private BookEntityRepository bookEntityRepository;


	private List<Books> books = new ArrayList<>();

	@PostConstruct
	public void init() {

	}

	public BookServiceDefault(RegexToDfa dfa, KMP kmp, BookEntityRepository bookEntityRepository) {
		this.regexToDfa = dfa;
		this.kmP = kmp;
		this.bookEntityRepository = bookEntityRepository;
	}

	public List<Books> books() {
		return books;
	}

	@Override
	public List<Document> findbyKeyword(String s) {
		List<Books> books = this.bookEntityRepository.books();
		List<Document> documents = new ArrayList<>();
		for (Books books2 : books) {
			String txt = books2.getContent().replaceAll("[\\n\\r\\s]+", " ");
			int counter = this.kmP.KMPSearch(s, txt);
			if (counter != 0) {
				documents.add(new Document(books2.getTitle(), books2.getAuthor(), books2.getReleaseDate(),
						books2.getLanguage(), counter,txt));
			}
		}
	
		return  documents;
	}

	@Override
	public List<Document> findByRegex(String regex) {

		this.regexToDfa.searchRegex(regex + "#", "ab abcd abc");

		return null;
	}

	@Override
	public List<Document> findByJaccard(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
