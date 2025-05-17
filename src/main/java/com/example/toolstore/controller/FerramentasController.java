package com.example.toolstore.controller;

import com.example.toolstore.model.Ferramenta;
import com.example.toolstore.service.FerramentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<Ferramenta> getFerramentaById(@PathVariable("id") String id){
        Ferramenta ferramenta = ferramentaService.findById(id);
        return ResponseEntity.ok(ferramenta);
    }

    @PostMapping
    public ResponseEntity<String> createFerramenta(@RequestBody Ferramenta ferramenta) {
        Ferramenta savedFerramenta = ferramentaService.save(ferramenta);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ferramenta criada com sucesso! ID: "+ savedFerramenta.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFerramenta(@PathVariable("id") String id, @RequestBody Ferramenta ferramenta) {
        ferramenta.setId(id);
        Ferramenta updateFerramenta =ferramentaService.save(ferramenta);
        return ResponseEntity.ok("Ferramenta atualizada com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFerramenta(@PathVariable("id") String id) {
        ferramentaService.delete(id);
        return ResponseEntity.ok("Ferramenta deletada com sucesso");
    }
}
