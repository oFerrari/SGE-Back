package br.com.sge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.dto.AdministradorDTO;
import br.com.sge.entities.Administrador;
import br.com.sge.repositories.AdministradorRepository;
import br.com.sge.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AdministradorService {
	@Autowired
	private AdministradorRepository repository;

	@Transactional(readOnly = true)
	public List<AdministradorDTO> findAll() {
		List<Administrador> lista = repository.findAll();

		return lista.stream().map(x -> new AdministradorDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public AdministradorDTO findById(Long id) {
		Optional<Administrador> obj = repository.findById(id);
		Administrador entity = obj
				.orElseThrow(() -> new ResourceNotFoundException("O registro solicitado não foi encontrado"));
		return new AdministradorDTO(entity);
	}

	@Transactional
	public AdministradorDTO insert(AdministradorDTO dto) {
		Administrador entity = new Administrador();
		entity.setFoto(dto.getFoto());
		entity.setEmail(dto.getEmail());
		entity.setSenha(dto.getSenha());

		entity = repository.save(entity);

		return new AdministradorDTO(entity);
	}

	@Transactional
	public AdministradorDTO update(Long id, AdministradorDTO dto) {
		try {
			Administrador entity = repository.getReferenceById(id);
			entity.setFoto(dto.getFoto());
			entity.setEmail(dto.getEmail());
			entity.setSenha(dto.getSenha());

			entity = repository.save(entity);

			return new AdministradorDTO(entity);
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
            throw new DataIntegrityViolationException("Erro de integridade referencial ao excluir o administrador: " + e.getMessage());
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
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não é possível excluir o administrador, pois está sendo usado em outra parte do sistema.");
//	    } catch (EmptyResultDataAccessException e) {
//	        throw new ResourceNotFoundException("O recurso com o ID " + id + " não foi localizado");
//	    }
//	}


}
