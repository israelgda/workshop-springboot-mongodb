package com.israelgda.workshopmongo.repositry;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.israelgda.workshopmongo.domain.Usuario;

@Repository
public interface RepositoryUsuario extends MongoRepository<Usuario, String>{

}
