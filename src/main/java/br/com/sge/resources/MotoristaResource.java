package br.com.sge.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sge.dto.MotoristaDTO;
import br.com.sge.services.MotoristaService;

@RestController
@RequestMapping(value = "/motoristas")
public class MotoristaResource {
	
	@Autowired
	private MotoristaService service;
	
	@GetMapping
	public ResponseEntity<List<MotoristaDTO>> findAll() {
		List<MotoristaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<MotoristaDTO> findById(@PathVariable Long id){	
		MotoristaDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<MotoristaDTO> insert(@RequestBody MotoristaDTO dto){	
		service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(null);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<MotoristaDTO> update(@PathVariable Long id, @RequestBody MotoristaDTO dto){ 
	dto = service.update(id, dto);
	return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
