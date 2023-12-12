package br.ufsm.backend_px.model.projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    public Projeto findByNome(String nome);

    @Query("SELECT DISTINCT p FROM Projeto p JOIN p.usuario u JOIN u.seguidores s WHERE s.id = :usuarioId")
    List<Projeto> findProjetosDosSeguidores(@Param("usuarioId") Long usuarioId);

    //long countProjetoByUsuario(String usuario);

}
