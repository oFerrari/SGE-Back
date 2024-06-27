package br.com.sge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Modulo_Acesso")
public class ModuloAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModuloAcesso;

    @ManyToOne
    @JoinColumn(name = "idModulo", nullable = false)
    private Modulo modulo;

    @ManyToOne
    @JoinColumn(name = "idNivelAcesso", nullable = false)
    private NivelDeAcesso nivelDeAcesso;

	public ModuloAcesso(Long idModuloAcesso, Modulo modulo, NivelDeAcesso nivelDeAcesso) {
		this.idModuloAcesso = idModuloAcesso;
		this.modulo = modulo;
		this.nivelDeAcesso = nivelDeAcesso;
	}

	public Long getIdModuloAcesso() {
		return idModuloAcesso;
	}

	public void setIdModuloAcesso(Long idModuloAcesso) {
		this.idModuloAcesso = idModuloAcesso;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public NivelDeAcesso getNivelDeAcesso() {
		return nivelDeAcesso;
	}

	public void setNivelDeAcesso(NivelDeAcesso nivelDeAcesso) {
		this.nivelDeAcesso = nivelDeAcesso;
	}

    
}
