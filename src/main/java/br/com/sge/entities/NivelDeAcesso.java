package br.com.sge.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "NivelDeAcesso")
public class NivelDeAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNivelDeAcesso;

    @Column(nullable = false, unique = true)
    private String nomeNivelDeAcesso;

    @OneToMany(mappedBy = "nivelDeAcesso", cascade = CascadeType.ALL)
    private Set<UsuarioNivelAcesso> usuarioNivelAcessos = new HashSet<>();

    @OneToMany(mappedBy = "nivelDeAcesso", cascade = CascadeType.ALL)
    private Set<ModuloAcesso> moduloAcessos = new HashSet<>();

    
	public NivelDeAcesso(Long idNivelDeAcesso, String nomeNivelDeAcesso) {
		super();
		this.idNivelDeAcesso = idNivelDeAcesso;
		this.nomeNivelDeAcesso = nomeNivelDeAcesso;
	}

	public Long getIdNivelDeAcesso() {
		return idNivelDeAcesso;
	}

	public void setIdNivelDeAcesso(Long idNivelDeAcesso) {
		this.idNivelDeAcesso = idNivelDeAcesso;
	}

	public String getNomeNivelDeAcesso() {
		return nomeNivelDeAcesso;
	}

	public void setNomeNivelDeAcesso(String nomeNivelDeAcesso) {
		this.nomeNivelDeAcesso = nomeNivelDeAcesso;
	}


}

