package com.example.toolstore.repository;

import com.example.toolstore.model.Ferramenta;
import com.example.toolstore.model.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FerramentaRepository extends MongoRepository<Ferramenta, String> {
}
