package br.com.sge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.dto.PedidoEntregaDTO;
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
	
	// Novo método para suporte à paginação
//    @Transactional(readOnly = true)
//    public Page<PedidoEntregaDTO> findAllPaged(Pageable pageable) {
//        Page<PedidoEntrega> result = repository.findAll(pageable); // Busca paginada do repositório
//        return result.map(PedidoEntregaDTO::new); // Converte a página de PedidoEntrega em PedidoEntregaDTO
//    }

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
	public PedidoEntregaDTO insert(PedidoEntregaDTO dto) {
		Veiculo veiculo = veiculoRepository.getReferenceById(dto.getVeiculoId());
		Cliente cliente = clienteRepository.getReferenceById(dto.getClienteId());
		
		PedidoEntrega entity = new PedidoEntrega();

		entity.setMercadoria(dto.getMercadoria());
		entity.setOrigem(dto.getOrigem());
		entity.setDestino(dto.getDestino());
		entity.setEmissao(dto.getEmissao());
		entity.setDataEntrega(dto.getDataEntrega());
		entity.setStatusPedido(dto.getStatusPedido());
		entity.setVeiculo(veiculo);
		entity.setCliente(cliente);

		entity = repository.save(entity);

		return new PedidoEntregaDTO(entity);
	}

	@Transactional
	public PedidoEntregaDTO update(Long id, PedidoEntregaDTO dto) {
		try {			
			Veiculo veiculo = veiculoRepository.getReferenceById(dto.getVeiculoId());
			Cliente cliente = clienteRepository.getReferenceById(dto.getClienteId());
			
			PedidoEntrega entity = repository.getReferenceById(id);			
			entity.setMercadoria(dto.getMercadoria());
			entity.setOrigem(dto.getOrigem());
			entity.setDestino(dto.getDestino());
			entity.setEmissao(dto.getEmissao());
			entity.setDataEntrega(dto.getDataEntrega());
			entity.setStatusPedido(dto.getStatusPedido());
			entity.setVeiculo(veiculo);
			entity.setCliente(cliente);

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
