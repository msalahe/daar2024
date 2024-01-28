package org.ms.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.ms.java.dao.BookRepository;
import org.ms.java.helper.regex.KMP;
import org.ms.java.models.Document;
import org.ms.java.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.alg.scoring.BetweennessCentrality;

@SpringBootApplication
public class SearchBookApplication {

	

	public static void main(String[] args) {
		SpringApplication.run(SearchBookApplication.class, args);
		//new SearchBookApplication();
		
	}
	
	
	
	
	  
	


}
