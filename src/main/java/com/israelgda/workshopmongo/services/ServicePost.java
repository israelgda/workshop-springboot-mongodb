package com.israelgda.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelgda.workshopmongo.domain.Post;
import com.israelgda.workshopmongo.repositry.RepositoryPost;
import com.israelgda.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class ServicePost {
	
	@Autowired
	private RepositoryPost repository;
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post findById(String id) {
		List<Post> list = findAll();
		Post post = null;
		for(Post u: list) {
			if(u.getId().equals(id)) {
				post = u;
			}
		}
		if (post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
		return post;
	}	
	
	public List<Post> findByTitulo(String texto){
		return repository.findByTitulo(texto);
	}
	
}
