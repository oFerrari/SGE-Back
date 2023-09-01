package br.com.sge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.dto.MotoristaDTO;
import br.com.sge.entities.Motorista;
import br.com.sge.repositories.MotoristaRepository;
import br.com.sge.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MotoristaService {
	@Autowired
	private MotoristaRepository repository;

	@Transactional(readOnly = true)
	public List<MotoristaDTO> findAll() {
		List<Motorista> lista = repository.findAll();

		return lista.stream().map(x -> new MotoristaDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public MotoristaDTO findById(Long id) {
		Optional<Motorista> obj = repository.findById(id);
		Motorista entity = obj
				.orElseThrow(() -> new ResourceNotFoundException("O registro solicitado não foi encontrado"));
		return new MotoristaDTO(entity);
	}

	@Transactional
	public MotoristaDTO insert(MotoristaDTO dto) {
		Motorista entity = new Motorista();
		entity.setNome(dto.getNome());
		entity.setCNH(dto.getCNH());
		entity.setCPF(dto.getCPF());
		entity.setEndereco(dto.getEndereco());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());

		entity = repository.save(entity);

		return new MotoristaDTO(entity);
	}

	@Transactional
	public MotoristaDTO update(Long id, MotoristaDTO dto) {
		try {
			Motorista entity = repository.getReferenceById(id);
			entity.setNome(dto.getNome());
			entity.setCNH(dto.getCNH());
			entity.setCPF(dto.getCPF());
			entity.setEndereco(dto.getEndereco());
			entity.setTelefone(dto.getTelefone());
			entity.setEmail(dto.getEmail());

			entity = repository.save(entity);

			return new MotoristaDTO(entity);
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
