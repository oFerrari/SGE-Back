package br.com.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sge.entities.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long>{

}
