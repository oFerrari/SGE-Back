package br.com.sge.dto;

import java.io.Serializable;

import br.com.sge.entities.Usuario;



public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;
	private String senha;

	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Long id, String foto, String email, String senha) {

		this.id = id;
		this.email = email;
		this.senha = senha;

	}
	
	public UsuarioDTO(Usuario entity) {

		this.id = entity.getId();
		this.email = entity.getEmail();
		this.senha = entity.getSenha();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
