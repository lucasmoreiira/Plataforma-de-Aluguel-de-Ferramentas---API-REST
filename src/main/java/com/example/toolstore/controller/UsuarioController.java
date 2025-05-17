package com.example.toolstore.controller;

import com.example.toolstore.model.Usuario;
import com.example.toolstore.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") String id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody Usuario usuario){
        Usuario savedUsuario= usuarioService.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario criado com sucesso! ID: "+ savedUsuario.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@PathVariable("id") String id, @RequestBody Usuario data){
        Usuario updatedUsuario = usuarioService.updateUsuario(id,data);
        return ResponseEntity.ok("Usuario atualizado com sucesso! ID: "+ updatedUsuario.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") String id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok("Usuario deletado com sucesso!");
    }
}
