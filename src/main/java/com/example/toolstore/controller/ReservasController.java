package com.example.toolstore.controller;


import com.example.toolstore.dto.FerramentaResumoDTO;
import com.example.toolstore.dto.ReservaDTO;
import com.example.toolstore.dto.UsuarioResumoDTO;
import com.example.toolstore.model.Reserva;
import com.example.toolstore.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public List<ReservaDTO> listar() {
        return service.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReservaDTO buscar(@PathVariable("id") String id) {
        Reserva reserva = service.findById(id);
        return mapToDTO(reserva);
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