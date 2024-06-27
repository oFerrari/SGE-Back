package br.com.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sge.entities.Modulo;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {
}
