package org.ms.java.services;

import java.util.List;

import javax.swing.text.Document;

import org.ms.java.helper.regex.KMP;
import org.ms.java.helper.regex.RegexToDfa;
import org.springframework.stereotype.Service;



@Service
public class BookServiceDefault implements BookService {
     
	private RegexToDfa regexToDfa;
	private KMP kmP;
	public BookServiceDefault(RegexToDfa dfa,KMP kmp) {
		this.regexToDfa = dfa;
		this.kmP = kmp;
	}

	@Override
	public List<Document> findbyKeyword(String s) {
          this.kmP.KMPSearch(s, "bo kdksdbokl bo dkqsjdkq bo");
		return null;
	}

	@Override
	public List<Document> findByRegex(String regex) {
             
		this.regexToDfa.searchRegex(regex+"#", "a");
		
		return null;
	}

	@Override
	public List<Document> findByJaccard(String s) {
		// TODO Auto-generated method stub
		return null;
	}



}
