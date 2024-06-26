package br.com.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sge.entities.Motorista;

@Repository
public interface MotoristaRepository extends JpaRepository <Motorista, Long>{

}
