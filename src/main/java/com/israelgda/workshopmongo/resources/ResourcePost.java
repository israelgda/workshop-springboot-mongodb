package com.israelgda.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.israelgda.workshopmongo.domain.Post;
import com.israelgda.workshopmongo.resources.util.URL;
import com.israelgda.workshopmongo.services.ServicePost;

@RestController
@RequestMapping(value="/posts")
public class ResourcePost {
	
	@Autowired
	private ServicePost service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){		
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value="/searchtitulo")
	public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value="text", defaultValue = "") String texto){		
		texto = URL.decodeParam(texto);
		List<Post> list = service.findByTitulo(texto);
		return ResponseEntity.ok().body(list);
	}
	
}
