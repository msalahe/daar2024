package org.ms.java.dao;

import java.util.List;

import org.ms.java.models.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookEntityRepository {

	
	public List<Books> books();
}
