package com.israelgda.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.israelgda.workshopmongo.domain.Usuario;
import com.israelgda.workshopmongo.services.ServiceUsuario;

@RestController
@RequestMapping(value="/usuarios")
public class ResourceUsuario {
	
	@Autowired
	private ServiceUsuario service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
}
