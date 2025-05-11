package com.example.toolstore.controller;

import com.example.toolstore.model.Reserva;
import com.example.toolstore.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public List<Reserva> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Reserva buscar(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping
    public Reserva criar(@RequestBody Reserva reserva) {
        return service.save(reserva);
    }

    @PutMapping("/{id}")
    public Reserva atualizar(@PathVariable("id") String id, @RequestBody Reserva reserva) {
        reserva.setId(id);
        return service.save(reserva);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id) {
        service.delete(id);
    }
}