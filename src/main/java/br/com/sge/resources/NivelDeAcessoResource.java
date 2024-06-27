package br.com.sge.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sge.entities.NivelDeAcesso;
import br.com.sge.services.NivelDeAcessoService;

@RestController
@RequestMapping("/api/niveis")
public class NivelDeAcessoResource {

    @Autowired
    private NivelDeAcessoService nivelDeAcessoService;

    @GetMapping
    public List<NivelDeAcesso> getAllNiveis() {
        return nivelDeAcessoService.findAll();
    }  
}