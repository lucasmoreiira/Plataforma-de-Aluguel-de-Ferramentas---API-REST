package com.example.toolstore.controller;

import com.example.toolstore.model.Usuario;
import com.example.toolstore.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable("id") String id){
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable("id") String id, @RequestBody Usuario data){
        return usuarioService.updateUsuario(id,data);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable("id") String id) {
        usuarioService.deleteUsuario(id);
    }
}
