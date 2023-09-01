package br.com.sge.dto;

import java.io.Serializable;

import br.com.sge.entities.Motorista;

public class MotoristaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String CNH;
	private String CPF;
	private String endereco;
	private String telefone;
	private String email;

	public MotoristaDTO() {
		
	}

	public MotoristaDTO(Long id, String nome, String CNH, String CPF, String endereco, String telefone, String email) {

		this.id = id;
		this.nome = nome;
		this.CNH = CNH;
		this.CPF = CPF;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}
	
	public MotoristaDTO(Motorista entity) {

		this.id = entity.getId();
		this.nome = entity.getNome();
		this.CNH = entity.getCNH();
		this.CPF = entity.getCPF();
		this.endereco = entity.getEndereco();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCNH() {
		return CNH;
	}

	public void setCNH(String CNH) {
		this.CNH = CNH;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
