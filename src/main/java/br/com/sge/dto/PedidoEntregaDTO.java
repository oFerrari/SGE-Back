package br.com.sge.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.sge.entities.Cliente;
import br.com.sge.entities.PedidoEntrega;
import br.com.sge.entities.enums.StatusPedido;

public class PedidoEntregaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Cliente cliente;
	private String mercadoria;
	private String origem;
	private String destino;
	private LocalDateTime emissao;
	private LocalDateTime dataEntrega;
	private StatusPedido statusPedido;

	public PedidoEntregaDTO() {
		
	}

	public PedidoEntregaDTO(Long id, Cliente cliente, String mercadoria, String origem, String destino,
			LocalDateTime emissao, LocalDateTime dataEntrega, StatusPedido statusPedido) {
		
		this.id = id;
		this.cliente = cliente;
		this.mercadoria = mercadoria;
		this.origem = origem;
		this.destino = destino;
		this.emissao = emissao;
		this.dataEntrega = dataEntrega;
		this.statusPedido = statusPedido;
	}
	
	public PedidoEntregaDTO(PedidoEntrega entity) {
		
		this.id = entity.getId();
		this.cliente = entity.getCliente();
		this.mercadoria = entity.getMercadoria();
		this.origem = entity.getOrigem();
		this.destino = entity.getDestino();
		this.emissao = entity.getEmissao();
		this.dataEntrega = entity.getDataEntrega();
		this.statusPedido = entity.getStatusPedido();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMercadoria() {
		return mercadoria;
	}

	public void setMercadoria(String mercadoria) {
		this.mercadoria = mercadoria;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDateTime getEmissao() {
		return emissao;
	}

	public void setEmissao(LocalDateTime emissao) {
		this.emissao = emissao;
	}

	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	


}
