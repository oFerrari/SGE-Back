package br.com.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sge.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findByEmail(String email);
}
