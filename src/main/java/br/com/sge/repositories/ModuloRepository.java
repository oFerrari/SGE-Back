package br.com.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sge.entities.Modulo;
@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {
}
