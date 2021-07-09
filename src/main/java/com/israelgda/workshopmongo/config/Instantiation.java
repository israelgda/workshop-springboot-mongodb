package com.israelgda.workshopmongo.config;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.israelgda.workshopmongo.domain.Post;
import com.israelgda.workshopmongo.domain.Usuario;
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
		//sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		Date data1 = (Date) sdf.parse("21/03/2021");
		Date data2 = (Date) sdf.parse("23/03/2021");
		
		Post post1 = new Post(null, data1, "Partiu Viagem!", "Vou viajar para SP abraços!", maria);
		Post post2 = new Post(null, data2, "Bom dia!", "Acordei feliz hoje!", maria);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
