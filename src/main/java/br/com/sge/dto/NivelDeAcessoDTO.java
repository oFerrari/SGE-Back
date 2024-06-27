package br.com.sge.dto;

public class NivelDeAcessoDTO {
    private Long idNivelDeAcesso;
    private String nomeNivelDeAcesso;
    
	public NivelDeAcessoDTO(Long idNivelDeAcesso, String nomeNivelDeAcesso) {
		this.idNivelDeAcesso = idNivelDeAcesso;
		this.nomeNivelDeAcesso = nomeNivelDeAcesso;
	}

	public Long getIdNivelDeAcesso() {
		return idNivelDeAcesso;
	}

	public void setIdNivelDeAcesso(Long idNivelDeAcesso) {
		this.idNivelDeAcesso = idNivelDeAcesso;
	}

	public String getNomeNivelDeAcesso() {
		return nomeNivelDeAcesso;
	}

	public void setNomeNivelDeAcesso(String nomeNivelDeAcesso) {
		this.nomeNivelDeAcesso = nomeNivelDeAcesso;
	}

}
