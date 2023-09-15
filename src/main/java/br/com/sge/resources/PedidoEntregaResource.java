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

import br.com.sge.dto.PedidoEntregaDTO;
import br.com.sge.services.PedidoEntregaService;

@RestController
@RequestMapping(value = "/pedidoEntregas")
public class PedidoEntregaResource {
	
	@Autowired
	private PedidoEntregaService service;
	
	@GetMapping
	public ResponseEntity<List<PedidoEntregaDTO>> findAll() {
		List<PedidoEntregaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<PedidoEntregaDTO> findById(@PathVariable Long id){	
		PedidoEntregaDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<PedidoEntregaDTO> insert(@RequestBody PedidoEntregaDTO dto){	
		service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(null);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PedidoEntregaDTO> update(@PathVariable Long id, @RequestBody PedidoEntregaDTO dto){ 
	dto = service.update(id, dto);
	return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
