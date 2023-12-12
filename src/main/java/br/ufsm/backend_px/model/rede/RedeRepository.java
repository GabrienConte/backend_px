package br.ufsm.backend_px.model.rede;

import br.ufsm.backend_px.model.projeto.Projeto;
import br.ufsm.backend_px.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RedeRepository extends JpaRepository<Rede, Long> {
    @Query("SELECT r FROM Rede r WHERE r.UsuarioOrigem.id = :idUsuarioOrigem AND r.UsuarioDestino.id = :idUsuarioDestino")
    Rede findRedeByUsuarioOrigemAndUsuarioDestino(@Param("idUsuarioOrigem") Long idUsuarioOrigem, @Param("idUsuarioDestino") Long idUsuarioDestino);

}
