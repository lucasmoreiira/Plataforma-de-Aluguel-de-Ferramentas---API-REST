package com.example.toolstore.controller;

import com.example.toolstore.model.Ferramenta;
import com.example.toolstore.service.FerramentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ferramentas")
public class FerramentasController {

    @Autowired
    private FerramentaService ferramentaService;


    @GetMapping
    private List<Ferramenta> getAllFerramenta(){
        return ferramentaService.findAll();
    }

    @GetMapping("/{id}")
    private Ferramenta getFerramentaById(@PathVariable("id") String id){
        return ferramentaService.findById(id);
    }

    @PostMapping
    public Ferramenta createFerramenta(@RequestBody Ferramenta ferramenta) {
        return ferramentaService.save(ferramenta);
    }

    @PutMapping("/{id}")
    public Ferramenta updateFerramenta(@PathVariable("id") String id, @RequestBody Ferramenta ferramenta) {
        ferramenta.setId(id);
        return ferramentaService.save(ferramenta);
    }

    @DeleteMapping("/{id}")
    public void deleteFerramenta(@PathVariable("id") String id) {
        ferramentaService.delete(id);
    }
}
