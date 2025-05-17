package com.example.toolstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "reservas")
public class Reserva {

    @Id
    private String id;
    private LocalDateTime dataInicioReserva;
    private LocalDateTime dataFimReserva;
    @DBRef
    private Usuario usuario;
    @DBRef
    private List<Ferramenta> ferramentas;


    public Reserva(String id, LocalDateTime dataInicioReserva, LocalDateTime dataFimReserva, Usuario usuario, List<Ferramenta> ferramentas) {
        this.id = id;
        this.dataInicioReserva = dataInicioReserva;
        this.dataFimReserva = dataFimReserva;
        this.usuario = usuario;
        this.ferramentas = ferramentas;
    }

    public Reserva() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public List<Ferramenta> getFerramentas() {
        return ferramentas;
    }

    public void setFerramentas(List<Ferramenta> ferramentas) {
        this.ferramentas = ferramentas;
    }
}
