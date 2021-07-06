package com.israelgda.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.israelgda.workshopmongo.domain.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class ResourceUsuario {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll(){
		Usuario maria = new Usuario("123", "Maria Silva", "maria@gmail.com");
		Usuario alex = new Usuario("124", "Alex", "alex@gmail.com");
		
		List<Usuario> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		
		return ResponseEntity.ok().body(list);
	}
}
