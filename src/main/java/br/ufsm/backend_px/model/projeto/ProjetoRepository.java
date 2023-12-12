package br.ufsm.backend_px.model.projeto;

import br.ufsm.backend_px.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    public Projeto findByNome(String nome);

    @Query("SELECT p FROM Projeto p JOIN p.usuario u WHERE u.id IN (SELECT r.UsuarioDestino.id FROM Rede r WHERE r.UsuarioOrigem.id = ?1)")
    List<Projeto> findProjetosSeguidosByUsuarioId(Long usuarioId);

    //long countProjetoByUsuario(String usuario);

}
