package com.example.toolstore.repository;

import com.example.toolstore.model.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReservaRepository  extends MongoRepository<Reserva, String> {
    List<Reserva> findByUsuarioId(String usuarioId);
}
