package com.israelgda.workshopmongo.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.israelgda.workshopmongo.domain.Usuario;
import com.israelgda.workshopmongo.dto.UsuarioDTO;
import com.israelgda.workshopmongo.services.ServiceUsuario;

@RestController
@RequestMapping(value="/usuarios")
public class ResourceUsuario {
	
	@Autowired
	private ServiceUsuario service;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){		
		List<Usuario> list = service.findAll();
		List<UsuarioDTO> listDTO = list.stream().map(objX -> new UsuarioDTO(objX)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable String id){		
		Usuario usuario = service.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}
}
