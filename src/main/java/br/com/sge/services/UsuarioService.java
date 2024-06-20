package br.com.sge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.dto.UsuarioDTO;
import br.com.sge.entities.Usuario;
import br.com.sge.repositories.UsuarioRepository;
import br.com.sge.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	@Transactional(readOnly = true)
	public List<UsuarioDTO> findAll() {
		List<Usuario> lista = repository.findAll();

		return lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public UsuarioDTO findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		Usuario entity = obj
				.orElseThrow(() -> new ResourceNotFoundException("O registro solicitado não foi encontrado"));
		return new UsuarioDTO(entity);
	}

	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		entity.setEmail(dto.getEmail());
		entity.setSenha(dto.getSenha());

		entity = repository.save(entity);

		return new UsuarioDTO(entity);
	}

	@Transactional
	public UsuarioDTO update(Long id, UsuarioDTO dto) {
		try {
			Usuario entity = repository.getReferenceById(id);
			entity.setEmail(dto.getEmail());
			entity.setSenha(dto.getSenha());

			entity = repository.save(entity);

			return new UsuarioDTO(entity);
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
            throw new DataIntegrityViolationException("Erro de integridade referencial ao excluir o usuario: " + e.getMessage());
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
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não é possível excluir o usuario, pois está sendo usado em outra parte do sistema.");
//	    } catch (EmptyResultDataAccessException e) {
//	        throw new ResourceNotFoundException("O recurso com o ID " + id + " não foi localizado");
//	    }
//	}


}
