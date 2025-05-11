package com.example.toolstore.service;

import com.example.toolstore.model.Reserva;
import com.example.toolstore.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;

    public List<Reserva> findAll() {
        return repository.findAll();
    }

    public Reserva findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Reserva save(Reserva reserva) {
        return repository.save(reserva);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
