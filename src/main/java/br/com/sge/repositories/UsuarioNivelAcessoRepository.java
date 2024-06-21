package br.com.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sge.entities.UsuarioNivelAcesso;
@Repository
public interface UsuarioNivelAcessoRepository extends JpaRepository<UsuarioNivelAcesso, Long> {
}
