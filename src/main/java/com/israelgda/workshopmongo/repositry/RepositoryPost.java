package com.israelgda.workshopmongo.repositry;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.israelgda.workshopmongo.domain.Post;

@Repository
public interface RepositoryPost extends MongoRepository<Post, String>{

	List<Post> findByTituloContainingIgnoreCase(String texto);
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitulo(String texto);
}
