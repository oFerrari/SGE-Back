package br.com.sge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "UsuarioNivelAcesso")
public class UsuarioNivelAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioNivelAcesso;

    @ManyToOne
    @JoinColumn(name = "idNivelAcesso", nullable = false)
    private NivelDeAcesso nivelDeAcesso;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    // Getters and Setters
}

