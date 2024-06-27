package br.com.sge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sge.entities.UsuarioNivelAcesso;
import br.com.sge.repositories.UsuarioNivelAcessoRepository;

@Service
public class UsuarioNivelAcessoService {

    @Autowired
    private UsuarioNivelAcessoRepository usuarioNivelAcessoRepository;

    public List<UsuarioNivelAcesso> findAll() {
        return usuarioNivelAcessoRepository.findAll();
    }

    public UsuarioNivelAcesso findById(Long id) {
        return usuarioNivelAcessoRepository.findById(id).orElse(null);
    }

    public UsuarioNivelAcesso save(UsuarioNivelAcesso usuarioNivelAcesso) {
        return usuarioNivelAcessoRepository.save(usuarioNivelAcesso);
    }

    public void delete(Long id) {
        usuarioNivelAcessoRepository.deleteById(id);
    }
}

