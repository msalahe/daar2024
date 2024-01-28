package org.ms.java.dao;

import java.util.List;

import org.ms.java.models.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Repository
public class BookRepository implements BookEntityRepository {

	@Autowired
	MongoTemplate mongoTemplate;


	public BookRepository() {
		// TODO Auto-generated constructor stub
	}




	@Override
	public List<Books> books() {
		try {
	        Query query = new Query();
	        query.limit(10);

	        return mongoTemplate.find(query, Books.class, "books");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    return null;
	}

}
