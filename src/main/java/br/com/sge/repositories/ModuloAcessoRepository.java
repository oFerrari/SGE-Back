package br.com.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sge.entities.ModuloAcesso;
@Repository
public interface ModuloAcessoRepository extends JpaRepository<ModuloAcesso, Long> {
}
