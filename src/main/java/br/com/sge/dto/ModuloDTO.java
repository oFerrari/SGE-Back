package br.com.sge.dto;

public class ModuloDTO {
    private Long idModulo;
    private String nomeModulo;
    
	public ModuloDTO(Long idModulo, String nomeModulo) {
		this.idModulo = idModulo;
		this.nomeModulo = nomeModulo;
	}

	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public String getNomeModulo() {
		return nomeModulo;
	}

	public void setNomeModulo(String nomeModulo) {
		this.nomeModulo = nomeModulo;
	}
	
	

	
}
