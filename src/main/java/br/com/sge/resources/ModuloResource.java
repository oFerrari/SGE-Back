package br.com.sge.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sge.entities.Modulo;
import br.com.sge.services.ModuloService;

@RestController
@RequestMapping("/api/modulos")
public class ModuloResource {

    @Autowired
    private ModuloService moduloService;

    @GetMapping
    public List<Modulo> getAllModulos() {
        return moduloService.findAll();
    }

    @GetMapping("/{id}")
    public Modulo getModuloById(@PathVariable Long id) {
        return moduloService.findById(id);
    }

    @PostMapping
    public Modulo createModulo(@RequestBody Modulo modulo) {
        return moduloService.save(modulo);
    }

    @DeleteMapping("/{id}")
    public void deleteModulo(@PathVariable Long id) {
        moduloService.delete(id);
    }
}

