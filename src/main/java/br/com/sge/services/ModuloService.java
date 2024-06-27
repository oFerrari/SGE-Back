package br.com.sge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sge.entities.Modulo;
import br.com.sge.repositories.ModuloRepository;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    public List<Modulo> findAll() {
        return moduloRepository.findAll();
    }

    public Modulo findById(Long id) {
        return moduloRepository.findById(id).orElse(null);
    }

    public Modulo save(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    public void delete(Long id) {
        moduloRepository.deleteById(id);
    }
}
