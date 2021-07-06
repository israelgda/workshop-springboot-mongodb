package com.israelgda.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.israelgda.workshopmongo.domain.Usuario;
import com.israelgda.workshopmongo.repositry.RepositoryUsuario;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private RepositoryUsuario userRepository;
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
