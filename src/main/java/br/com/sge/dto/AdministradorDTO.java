package br.com.sge.dto;

import java.io.Serializable;

import br.com.sge.entities.Administrador;



public class AdministradorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String foto;
	private String email;
	private String senha;

	public AdministradorDTO() {
		
	}

	public AdministradorDTO(Long id, String foto, String email, String senha) {

		this.id = id;
		this.foto = foto;
		this.email = email;
		this.senha = senha;

	}
	
	public AdministradorDTO(Administrador entity) {

		this.id = entity.getId();
		this.foto = entity.getFoto();
		this.email = entity.getEmail();
		this.senha = entity.getSenha();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


}
