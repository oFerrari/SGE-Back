package br.com.sge.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sge.entities.Motorista;
import br.com.sge.entities.Veiculo;

public class VeiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long id;
	private String placa;
	private String documento;
	private String modelo;
	private String capacidade;
	
	private List<Motorista> motorista = new ArrayList<>();


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
	public VeiculoDTO(Veiculo entidade, List<Motorista> motoristas) {
	    this(entidade);
	    this.motorista = motoristas.stream().map(x -> new Motorista(
	            x.getId(), x.getNome(), x.getCNH(), x.getCPF(), x.getEndereco(), x.getTelefone(), x.getEmail()))
	            .collect(Collectors.toList());
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
