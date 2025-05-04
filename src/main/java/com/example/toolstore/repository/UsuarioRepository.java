package com.example.toolstore.repository;

import com.example.toolstore.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository <Usuario, String> {
}
