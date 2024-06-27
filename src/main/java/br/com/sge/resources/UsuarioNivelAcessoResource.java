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

import br.com.sge.entities.UsuarioNivelAcesso;
import br.com.sge.services.UsuarioNivelAcessoService;

@RestController
@RequestMapping("/api/usuario-niveis")
public class UsuarioNivelAcessoResource {

    @Autowired
    private UsuarioNivelAcessoService usuarioNivelAcessoService;

    @GetMapping
    public List<UsuarioNivelAcesso> getAllUsuarioNiveis() {
        return usuarioNivelAcessoService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioNivelAcesso getUsuarioNivelById(@PathVariable Long id) {
        return usuarioNivelAcessoService.findById(id);
    }

    @PostMapping
    public UsuarioNivelAcesso createUsuarioNivel(@RequestBody UsuarioNivelAcesso usuarioNivelAcesso) {
        return usuarioNivelAcessoService.save(usuarioNivelAcesso);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuarioNivel(@PathVariable Long id) {
        usuarioNivelAcessoService.delete(id);
    }
}
