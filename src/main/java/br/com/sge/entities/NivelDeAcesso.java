package br.com.sge.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NivelDeAcesso")
public class NivelDeAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNivelDeAcesso;

    @Column(nullable = false, unique = true)
    private String nomeNivelDeAcesso;
    
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

