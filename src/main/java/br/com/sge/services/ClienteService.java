package br.com.sge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.dto.ClienteDTO;
import br.com.sge.entities.Cliente;
import br.com.sge.repositories.ClienteRepository;
import br.com.sge.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;

	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll() {
		List<Cliente> lista = repository.findAll();

		return lista.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		Cliente entity = obj
				.orElseThrow(() -> new ResourceNotFoundException("O registro solicitado não foi encontrado"));
		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		Cliente entity = new Cliente();
		entity.setNome(dto.getNome());
		entity.setTipo(dto.getTipo());
		entity.setDocumento(dto.getDocumento());
		entity.setEndereco(dto.getEndereco());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());

		entity = repository.save(entity);

		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		try {
			Cliente entity = repository.getReferenceById(id);
			entity.setNome(dto.getNome());
			entity.setTipo(dto.getTipo());
			entity.setDocumento(dto.getDocumento());
			entity.setEndereco(dto.getEndereco());
			entity.setTelefone(dto.getTelefone());
			entity.setEmail(dto.getEmail());

			entity = repository.save(entity);

			return new ClienteDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O recurso com o ID " + id + " não foi localizado");
		}
	}

	public void delete(Long id) {
	    try {
	        repository.deleteById(id);
	    } catch (EmptyResultDataAccessException e) {
	        throw new ResourceNotFoundException("O recurso com o ID " + id + " não foi localizado");
	    } catch (DataIntegrityViolationException e) {
            // Lidar com o erro de integridade referencial, se necessário
            throw new DataIntegrityViolationException("Erro de integridade referencial ao excluir o cliente: " + e.getMessage());
        }
	}
	
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<String> delete(@PathVariable Long id) {
//	    try {
//	        repository.deleteById(id);
//	        // Exclusão bem-sucedida
//	        return ResponseEntity.ok("Exclusão bem-sucedida.");
//	    } catch (DataIntegrityViolationException e) {
//	        // Lidar com o erro de integridade referencial
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não é possível excluir o cliente, pois está sendo usado em outra parte do sistema.");
//	    } catch (EmptyResultDataAccessException e) {
//	        throw new ResourceNotFoundException("O recurso com o ID " + id + " não foi localizado");
//	    }
//	}


}
