package com.example.toolstore.dto;

import com.example.toolstore.model.Ferramenta;

import java.time.LocalDateTime;
import java.util.List;

public class ReservaDTO {

    private String id;
    private LocalDateTime dataInicioReserva;
    private LocalDateTime dataFimReserva;
    private UsuarioResumoDTO usuario;
    private List<FerramentaResumoDTO> ferramentas;

    public ReservaDTO(String id, LocalDateTime dataInicioReserva, LocalDateTime dataFimReserva, UsuarioResumoDTO usuario) {
        this.id = id;
        this.dataInicioReserva = dataInicioReserva;
        this.dataFimReserva = dataFimReserva;
        this.usuario = usuario;
    }

    public ReservaDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDataInicioReserva() {
        return dataInicioReserva;
    }

    public void setDataInicioReserva(LocalDateTime dataInicioReserva) {
        this.dataInicioReserva = dataInicioReserva;
    }

    public LocalDateTime getDataFimReserva() {
        return dataFimReserva;
    }

    public void setDataFimReserva(LocalDateTime dataFimReserva) {
        this.dataFimReserva = dataFimReserva;
    }

    public UsuarioResumoDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResumoDTO usuario) {
        this.usuario = usuario;
    }

    public List<FerramentaResumoDTO> getFerramentas() {
        return ferramentas;
    }

    public void setFerramentas(List<FerramentaResumoDTO> ferramentas) {
        this.ferramentas = ferramentas;
    }
}
