package br.com.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sge.entities.NivelDeAcesso;

public interface NivelDeAcessoRepository extends JpaRepository<NivelDeAcesso, Long> {
}
