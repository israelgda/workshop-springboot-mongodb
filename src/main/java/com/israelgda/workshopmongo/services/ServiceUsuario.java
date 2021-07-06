package com.israelgda.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelgda.workshopmongo.domain.Usuario;
import com.israelgda.workshopmongo.repositry.RepositoryUsuario;

@Service
public class ServiceUsuario {
	
	@Autowired
	private RepositoryUsuario repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
}
