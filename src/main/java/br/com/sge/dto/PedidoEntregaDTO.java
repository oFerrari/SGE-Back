package br.com.sge.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.sge.entities.PedidoEntrega;
import br.com.sge.entities.enums.StatusPedido;

public class PedidoEntregaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String mercadoria;
	private String origem;
	private String destino;
	private LocalDateTime emissao;
	private LocalDateTime dataEntrega;
	private StatusPedido statusPedido;
	private String nomeCliente;
	private Long clienteId;
	private String nomeVeiculo;
	private Long veiculoId;
	private VeiculoDTO veiculo;
	private ClienteDTO cliente;

	public PedidoEntregaDTO() {
		
	}

	public PedidoEntregaDTO(Long id, String nomeCliente, String mercadoria, String origem, String destino,
			LocalDateTime emissao, LocalDateTime dataEntrega, StatusPedido statusPedido, String nomeVeiculo) {
		
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.mercadoria = mercadoria;
		this.origem = origem;
		this.destino = destino;
		this.emissao = emissao;
		this.dataEntrega = dataEntrega;
		this.statusPedido = statusPedido;
		this.nomeVeiculo = nomeVeiculo;
	}
	
	public PedidoEntregaDTO(PedidoEntrega entity) {
		
		this.id = entity.getId();
		this.nomeCliente = entity.getCliente().getNome();
		this.mercadoria = entity.getMercadoria();
		this.origem = entity.getOrigem();
		this.destino = entity.getDestino();
		this.emissao = entity.getEmissao();
		this.dataEntrega = entity.getDataEntrega();
		this.statusPedido = entity.getStatusPedido();
		this.nomeVeiculo = entity.getVeiculo().getModelo();
		this.veiculoId = (entity.getVeiculo().getId());
		this.clienteId = (entity.getCliente().getId());
		this.veiculo = new VeiculoDTO(entity.getVeiculo());
		this.cliente = new ClienteDTO(entity.getCliente());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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

	public String getNomeVeiculo() {
		return nomeVeiculo;
	}

	public void setNomeVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}

	public VeiculoDTO getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	


}
