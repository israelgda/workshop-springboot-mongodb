package com.israelgda.workshopmongo.dto;

import java.io.Serializable;

import com.israelgda.workshopmongo.domain.Usuario;

public class AutorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String nome;
	
	//Construtores
	public AutorDTO() {
		
	}
	
	public AutorDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
	}

	//Getters & Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}	
