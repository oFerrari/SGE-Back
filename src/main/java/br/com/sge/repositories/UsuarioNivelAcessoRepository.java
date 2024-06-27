package br.com.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sge.entities.UsuarioNivelAcesso;

public interface UsuarioNivelAcessoRepository extends JpaRepository<UsuarioNivelAcesso, Long> {
}
