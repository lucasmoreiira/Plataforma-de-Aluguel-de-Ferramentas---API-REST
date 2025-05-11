package com.example.toolstore.service;

import com.example.toolstore.model.Ferramenta;
import com.example.toolstore.repository.FerramentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FerramentaService {
    @Autowired
    private FerramentaRepository repository;

    public List<Ferramenta> findAll() {
        return repository.findAll();
    }

    public Ferramenta findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Ferramenta save(Ferramenta ferramenta) {
        return repository.save(ferramenta);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}