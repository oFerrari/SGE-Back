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
@Table(name = "Modulo")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModulo;

    @Column(nullable = false, unique = true)
    private String nomeModulo;

    @OneToMany(mappedBy = "modulo", cascade = CascadeType.ALL)
    private Set<ModuloAcesso> moduloAcessos = new HashSet<>();

    // Getters e Setters

    
	public Modulo(Long idModulo, String nomeModulo) {
		this.idModulo = idModulo;
		this.nomeModulo = nomeModulo;
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
    
    
}

