package com.israelgda.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelgda.workshopmongo.domain.Usuario;
import com.israelgda.workshopmongo.dto.UsuarioDTO;
import com.israelgda.workshopmongo.repositry.RepositoryUsuario;
import com.israelgda.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class ServiceUsuario {
	
	@Autowired
	private RepositoryUsuario repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(String id) {
		List<Usuario> list = findAll();
		Usuario usuario = null;
		for(Usuario u: list) {
			if(u.getId().equals(id)) {
				usuario = u;
			}
		}
		if (usuario == null) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
		return usuario;
	}
	
	public Usuario insert(Usuario usuario) {
		return repository.insert(usuario);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Usuario update(Usuario usuario) {
		Usuario novoUsuario = findById(usuario.getId());
		updateData(novoUsuario, usuario);
		return repository.save(novoUsuario);
	}
	
	private void updateData(Usuario novoUsuario, Usuario usuario) {
		novoUsuario.setNome(usuario.getNome());
		novoUsuario.setEmail(usuario.getEmail());
	}

	public Usuario fromDTO(UsuarioDTO UsuarioDTO) {
		return new Usuario(UsuarioDTO.getId(), UsuarioDTO.getNome(), UsuarioDTO.getEmail());
	}
	
	
}
