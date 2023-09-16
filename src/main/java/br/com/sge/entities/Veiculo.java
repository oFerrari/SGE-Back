package br.com.sge.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String placa;
	private String documento;
	private String modelo;
	private String capacidade;
	
	@OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Motorista> motorista;
	
	public Veiculo() {
		
	}
	public Veiculo(Long id, String placa, String documento, String modelo, String capacidade, List<Motorista> motorista) {

		this.id = id;
		this.placa = placa;
		this.documento = documento;
		this.modelo = modelo;
		this.capacidade = capacidade;
		this.motorista = motorista;
	}
	
	
	
	public List<Motorista> getMotorista() {
		return motorista;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(capacidade, documento, id, modelo, placa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(capacidade, other.capacidade) && Objects.equals(documento, other.documento)
				&& Objects.equals(id, other.id) && Objects.equals(modelo, other.modelo)
				&& Objects.equals(placa, other.placa);
	}
	

}
