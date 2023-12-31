package br.com.sge.dto;

import java.io.Serializable;

import br.com.sge.entities.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String tipo;
	private String documento;
	private String endereco;
	private String telefone;
	private String email;

	public ClienteDTO() {
		
	}

	public ClienteDTO(Long id, String nome, String tipo, String documento, String endereco, String telefone, String email) {

		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.documento = documento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}
	
	public ClienteDTO(Cliente entity) {

		this.id = entity.getId();
		this.nome = entity.getNome();
		this.tipo = entity.getTipo();
		this.documento = entity.getDocumento();
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setdocumento(String documento) {
		this.documento = documento;
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
