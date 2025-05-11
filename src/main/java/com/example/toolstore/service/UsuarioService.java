package com.example.toolstore.service;

import com.example.toolstore.model.Usuario;
import com.example.toolstore.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(String id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(String id){
        usuarioRepository.deleteById(id);
    }

    public Usuario updateUsuario(String id, Usuario usuarioAtualizado){
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));

            usuarioExistente.setNome(usuarioAtualizado.getNome());
            usuarioExistente.setCpf(usuarioAtualizado.getCpf());
            usuarioExistente.setEndereco(usuarioAtualizado.getEndereco());
            usuarioExistente.setTelefone(usuarioAtualizado.getTelefone());

            return usuarioRepository.save(usuarioExistente);
    }
}
