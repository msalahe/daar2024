package org.ms.java.services;

import java.util.List;

import javax.swing.text.Document;

public interface BookService {
    
	public List<Document> findbyKeyword(String s);
	
	public List<Document> findByRegex(String regex);
    
	public List<Document> findByJaccard(String s);
	

	
}
