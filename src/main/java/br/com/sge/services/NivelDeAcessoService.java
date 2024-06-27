package br.com.sge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sge.entities.NivelDeAcesso;
import br.com.sge.repositories.NivelDeAcessoRepository;

@Service
public class NivelDeAcessoService {

    @Autowired
    private NivelDeAcessoRepository nivelDeAcessoRepository;

    public List<NivelDeAcesso> findAll() {
        return nivelDeAcessoRepository.findAll();
    }

    public NivelDeAcesso findById(Long id) {
        return nivelDeAcessoRepository.findById(id).orElse(null);
    }

    public NivelDeAcesso save(NivelDeAcesso nivelDeAcesso) {
        return nivelDeAcessoRepository.save(nivelDeAcesso);
    }

    public void delete(Long id) {
        nivelDeAcessoRepository.deleteById(id);
    }
}
