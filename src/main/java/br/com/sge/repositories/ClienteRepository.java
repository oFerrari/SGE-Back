package br.com.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sge.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
