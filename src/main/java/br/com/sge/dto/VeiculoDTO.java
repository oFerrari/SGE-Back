package br.com.sge.dto;

import java.io.Serializable;

import br.com.sge.entities.Veiculo;

public class VeiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long id;
	private String placa;
	private String documento;
	private String modelo;
	private String capacidade;


	public VeiculoDTO() {
		
	}

	public VeiculoDTO(Long id, String placa, String documento, String Modelo, String capacidade) {

		this.id = id;
		this.placa = placa;
		this.documento = documento;
		this.modelo = Modelo;
		this.capacidade = capacidade;
	
	}
	
	public VeiculoDTO(Veiculo entity) {

		this.id = entity.getId();
		this.placa = entity.getPlaca();
		this.documento= entity.getDocumento();
		this.modelo = entity.getModelo();
		this.capacidade = entity.getCapacidade();
		
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

	public void setModelo(String Modelo) {
		this.modelo = Modelo;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	

	


}
