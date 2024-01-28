package org.ms.java.services;

import java.util.List;


import org.ms.java.models.Books;
import org.ms.java.models.Document;

public interface BookService {
    
	public List<Document> findbyKeyword(String s);
	
	public List<Document> findByRegex(String regex);
    
	public List<Document> findByJaccard(String s);
	 
	public List<Books> books();

	
}
