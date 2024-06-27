package br.com.sge.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Modulo")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModulo;

    @Column(nullable = false, unique = true)
    private String nomeModulo;

    @OneToMany(mappedBy = "modulo")
    private Set<ModuloAcesso> moduloAcessos = new HashSet<>();

	public Modulo(Long idModulo, String nomeModulo, Set<ModuloAcesso> moduloAcessos) {
		this.idModulo = idModulo;
		this.nomeModulo = nomeModulo;
		this.moduloAcessos = moduloAcessos;
	}

	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public String getNomeModulo() {
		return nomeModulo;
	}

	public void setNomeModulo(String nomeModulo) {
		this.nomeModulo = nomeModulo;
	}

	public Set<ModuloAcesso> getModuloAcessos() {
		return moduloAcessos;
	}

	public void setModuloAcessos(Set<ModuloAcesso> moduloAcessos) {
		this.moduloAcessos = moduloAcessos;
	}

    
}

