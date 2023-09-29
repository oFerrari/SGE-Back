package br.com.sge.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sge.entities.Motorista;
import br.com.sge.entities.Veiculo;

public class VeiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long id;
	private String placa;
	private String renavam;
	private String modelo;
	private String capacidade;
	
	private List<Motorista> motorista = new ArrayList<>();

	private Motorista motorista;

	




	public VeiculoDTO() {
		
	}

	public VeiculoDTO(Long id, String placa, String renavam, String modelo, String capacidade) {

		this.id = id;
		this.placa = placa;
		this.renavam = renavam;
		this.modelo = modelo;
		this.capacidade = capacidade;

	}
	
	public VeiculoDTO(Veiculo entity) {

		this.id = entity.getId();
		this.placa = entity.getPlaca();
		this.renavam= entity.getRenavam();
		this.modelo = entity.getModelo();
		this.capacidade = entity.getCapacidade();

	}
	public VeiculoDTO(Veiculo entidade, List<Motorista> motoristas) {
	    this(entidade);
	    this.motorista = motoristas.stream().map(x -> new Motorista(
	            x.getId(), x.getNome(), x.getCNH(), x.getCPF(), x.getEndereco(), x.getTelefone(), x.getEmail()))
	            .collect(Collectors.toList());
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

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
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

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	

}
