package com.israelgda.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.israelgda.workshopmongo.domain.Post;
import com.israelgda.workshopmongo.domain.Usuario;
import com.israelgda.workshopmongo.dto.AutorDTO;
import com.israelgda.workshopmongo.dto.ComentarioDTO;
import com.israelgda.workshopmongo.repositry.RepositoryPost;
import com.israelgda.workshopmongo.repositry.RepositoryUsuario;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private RepositoryUsuario userRepository;
	
	@Autowired
	private RepositoryPost postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2021"), "Partiu viagem!", "Vou viajar para SP!", new AutorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2021"), "Bom dia!", "Acordei feliz hoje!", new AutorDTO(maria));
		
		ComentarioDTO coment1 = new ComentarioDTO("Bao viagem mano!", sdf.parse("21/03/2021!"),new AutorDTO(alex));
		ComentarioDTO coment2 = new ComentarioDTO("Aproveite!", sdf.parse("22/03/2021!"),new AutorDTO(bob));
		ComentarioDTO coment3 = new ComentarioDTO("Tenha um ótimo dia!", sdf.parse("23/03/2021!"),new AutorDTO(alex));
		
		post1.getComentarios().addAll(Arrays.asList(coment1, coment2));
		post2.getComentarios().addAll(Arrays.asList(coment3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);
		
	}

}
