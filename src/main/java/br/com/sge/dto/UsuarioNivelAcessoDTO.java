package br.com.sge.dto;

public class UsuarioNivelAcessoDTO {
    private Long idUsuarioNivelAcesso;
    private Long idNivelAcesso;
    private Long idUsuario;
    
	public UsuarioNivelAcessoDTO(Long idUsuarioNivelAcesso, Long idNivelAcesso, Long idUsuario) {
		this.idUsuarioNivelAcesso = idUsuarioNivelAcesso;
		this.idNivelAcesso = idNivelAcesso;
		this.idUsuario = idUsuario;
	}

	public Long getIdUsuarioNivelAcesso() {
		return idUsuarioNivelAcesso;
	}

	public void setIdUsuarioNivelAcesso(Long idUsuarioNivelAcesso) {
		this.idUsuarioNivelAcesso = idUsuarioNivelAcesso;
	}

	public Long getIdNivelAcesso() {
		return idNivelAcesso;
	}

	public void setIdNivelAcesso(Long idNivelAcesso) {
		this.idNivelAcesso = idNivelAcesso;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

    
}
