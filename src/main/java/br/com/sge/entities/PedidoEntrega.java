package br.com.sge.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import br.com.sge.entities.enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido_entrega")
public class PedidoEntrega implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mercadoria;
	private String origem;
	private String destino;
	private LocalDateTime emissao;
	private LocalDateTime dataEntrega;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido statusPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_veiculo_fk")
	private Veiculo veiculo;
	
	
	public PedidoEntrega() {
		
	}
	
	public PedidoEntrega(Long id, String mercadoria, String origem, String destino,LocalDateTime emissao, LocalDateTime dataEntrega, StatusPedido statusPedido) {

		this.id = id;
		this.mercadoria = mercadoria;
		this.origem = origem;
		this.destino = destino;
		this.emissao = emissao;
		this.dataEntrega = dataEntrega;
		this.statusPedido = statusPedido;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, dataEntrega, destino, emissao, id, mercadoria, origem, statusPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoEntrega other = (PedidoEntrega) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(dataEntrega, other.dataEntrega)
				&& Objects.equals(destino, other.destino) && Objects.equals(emissao, other.emissao)
				&& Objects.equals(id, other.id) && Objects.equals(mercadoria, other.mercadoria)
				&& Objects.equals(origem, other.origem) && statusPedido == other.statusPedido;
	}
	
	
}
