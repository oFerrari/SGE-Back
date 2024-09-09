package br.com.sge.tests;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.sge.dto.PedidoEntregaDTO;
import br.com.sge.entities.Cliente;
import br.com.sge.entities.PedidoEntrega;
import br.com.sge.entities.Veiculo;
import br.com.sge.entities.enums.StatusPedido;

public class Factory {

    // Método para criar uma instância de Cliente com base no ID
    public static Cliente createCliente(Long id) {
        // Ajustado conforme o construtor da classe Cliente
        return new Cliente(id, "Cliente " + id, "Tipo " + id, "Documento " + id, "Endereco " + id, "(67) 99999-" + (7000 + id), "email" + id + "@teste.com");
    }

    // Método para criar uma instância de Veículo com base no ID
    public static Veiculo createVeiculo(Long id) {
        // Ajustado conforme o construtor da classe Veiculo
        return new Veiculo(id, "Placa " + id, "Renavam " + id, "Modelo " + id, "Capacidade " + id);
    }
    
    // Método para criar uma instância de PedidoEntrega com dados específicos
    public static PedidoEntrega createPedidoEntrega(Long id) {
        Cliente cliente = createCliente(id % 5 + 1); // Ajusta o cliente baseado no ID
        Veiculo veiculo = createVeiculo(id % 4 + 1); // Ajusta o veículo baseado no ID

        PedidoEntrega pedidoEntrega = new PedidoEntrega();
        pedidoEntrega.setId(id);
        pedidoEntrega.setMercadoria("Mercadoria " + id);
        pedidoEntrega.setOrigem("Origem " + id);
        pedidoEntrega.setDestino("Destino " + id);
        pedidoEntrega.setEmissao(LocalDateTime.of(2023, 11, 15, 14, 0).plusDays(id)); // Ajuste conforme necessário
        pedidoEntrega.setDataEntrega(LocalDateTime.of(2023, 11, 16, 16, 30).plusDays(id)); // Ajuste conforme necessário
        pedidoEntrega.setStatusPedido(StatusPedido.PENDENTE); // Usa a enumeração StatusPedido
        pedidoEntrega.setCliente(cliente);
        pedidoEntrega.setVeiculo(veiculo);

        return pedidoEntrega;
    }

    // Método para criar uma instância de PedidoEntregaDTO com dados específicos
    public static PedidoEntregaDTO createPedidoEntregaDTO(Long id) {
        PedidoEntrega pedidoEntrega = createPedidoEntrega(id);
        return new PedidoEntregaDTO(pedidoEntrega);
    }
    
        public static PedidoEntregaDTO createPedidoEntregaDTO() {
            return new PedidoEntregaDTO(null, "Mercadoria Teste", "Origem Teste", "Destino Teste", LocalDate.now(), LocalDate.now().plusDays(1), "Status Teste", 1L, 1L);
        }



    // Métodos específicos para criar instâncias com IDs fixos
    public static PedidoEntrega createPedidoEntrega1() {
        return createPedidoEntrega(1L);
    }

    public static PedidoEntrega createPedidoEntrega2() {
        return createPedidoEntrega(2L);
    }

    public static PedidoEntrega createPedidoEntrega3() {
        return createPedidoEntrega(3L);
    }

    public static PedidoEntrega createPedidoEntrega4() {
        return createPedidoEntrega(4L);
    }

    public static PedidoEntrega createPedidoEntrega5() {
        return createPedidoEntrega(5L);
    }

    public static PedidoEntregaDTO createPedidoEntregaDTO1() {
        return createPedidoEntregaDTO(1L);
    }

    public static PedidoEntregaDTO createPedidoEntregaDTO2() {
        return createPedidoEntregaDTO(2L);
    }

    public static PedidoEntregaDTO createPedidoEntregaDTO3() {
        return createPedidoEntregaDTO(3L);
    }

    public static PedidoEntregaDTO createPedidoEntregaDTO4() {
        return createPedidoEntregaDTO(4L);
    }

    public static PedidoEntregaDTO createPedidoEntregaDTO5() {
        return createPedidoEntregaDTO(5L);
    }
}
