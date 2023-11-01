package br.com.sge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.dto.PedidoEntregaDTO;
import br.com.sge.dto.PedidoEntregaDTOFORM;
import br.com.sge.entities.Cliente;
import br.com.sge.entities.PedidoEntrega;
import br.com.sge.entities.Veiculo;
import br.com.sge.repositories.ClienteRepository;
import br.com.sge.repositories.PedidoEntregaRepository;
import br.com.sge.repositories.VeiculoRepository;
import br.com.sge.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoEntregaService {
	@Autowired
	private PedidoEntregaRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	@Transactional(readOnly = true)
	public List<PedidoEntregaDTO> findAll() {
		List<PedidoEntrega> lista = repository.findAll();

		return lista.stream().map(x -> new PedidoEntregaDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public PedidoEntregaDTO findById(Long id) {
		Optional<PedidoEntrega> obj = repository.findById(id);
		PedidoEntrega entity = obj
				.orElseThrow(() -> new ResourceNotFoundException("O registro solicitado não foi encontrado"));
		return new PedidoEntregaDTO(entity);
	}

	@Transactional
	public PedidoEntregaDTO insert(PedidoEntregaDTOFORM dto) {
		Veiculo veiculo = veiculoRepository.getReferenceById(dto.getIdVeiculo());
		Cliente cliente = clienteRepository.getReferenceById(dto.getIdCliente());
		
		PedidoEntrega entity = new PedidoEntrega();

		entity.setVeiculo(veiculo);
		entity.setCliente(cliente);
		entity.setMercadoria(dto.getMercadoria());
		entity.setOrigem(dto.getOrigem());
		entity.setDestino(dto.getDestino());
		entity.setEmissao(dto.getEmissao());
		entity.setDataEntrega(dto.getDataEntrega());
		entity.setStatusPedido(dto.getStatusPedido());

		entity = repository.save(entity);

		return new PedidoEntregaDTO(entity);
	}

	@Transactional
	public PedidoEntregaDTO update(Long id, PedidoEntregaDTOFORM dto) {
		try {
			Veiculo veiculo = veiculoRepository.getReferenceById(dto.getIdVeiculo());
			Cliente cliente = clienteRepository.getReferenceById(dto.getIdCliente());
			
			PedidoEntrega entity = repository.getReferenceById(id);
			
			entity.setVeiculo(veiculo);
			entity.setCliente(cliente);
			entity.setMercadoria(dto.getMercadoria());
			entity.setOrigem(dto.getOrigem());
			entity.setDestino(dto.getDestino());
			entity.setEmissao(dto.getEmissao());
			entity.setDataEntrega(dto.getDataEntrega());
			entity.setStatusPedido(dto.getStatusPedido());

			entity = repository.save(entity);

			return new PedidoEntregaDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O recurso com o ID " + id + " não foi localizado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("O recurso com o ID " + id + " não foi localizado");
		}
	}
}
