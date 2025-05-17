package com.example.toolstore.controller;


import com.example.toolstore.dto.FerramentaResumoDTO;
import com.example.toolstore.dto.ReservaDTO;
import com.example.toolstore.dto.UsuarioResumoDTO;
import com.example.toolstore.model.Reserva;
import com.example.toolstore.model.Usuario;
import com.example.toolstore.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public List<ReservaDTO> listarr() {
        return service.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> buscar(@PathVariable("id") String id) {
        Reserva reserva = service.findById(id);
        return ResponseEntity.ok(mapToDTO(reserva));
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Reserva reserva) {
        Reserva savedReserva =service.save(reserva);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Reserva criada com sucesso! ID: "+ savedReserva.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable("id") String id, @RequestBody Reserva reserva) {
        reserva.setId(id);
        Reserva updatedReserva = service.save(reserva);
        return ResponseEntity.ok("Reserva atualizada com sucesso! ID: "+ updatedReserva.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.ok("Reserva deletada com sucesso!");
    }

    private ReservaDTO mapToDTO(Reserva reserva){
        ReservaDTO dto = new ReservaDTO();
        dto.setId(reserva.getId());
        dto.setDataInicioReserva(reserva.getDataInicioReserva());
        dto.setDataFimReserva(reserva.getDataFimReserva());

        if(reserva.getUsuario() != null) {
            dto.setUsuario(new UsuarioResumoDTO(
                    reserva.getUsuario().getId(),
                    reserva.getUsuario().getNome()
            ));
        }
        if(reserva.getFerramentas() != null) {
            List<FerramentaResumoDTO> ferramentaResumo = reserva.getFerramentas().stream()
                    .map(f -> new FerramentaResumoDTO(f.getId(), f.getNome()))
                    .collect(Collectors.toList());
            dto.setFerramentas(ferramentaResumo);
        }else{
            dto.setFerramentas(List.of());
        }
        return dto;
    }
}