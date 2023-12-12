package br.ufsm.backend_px.model.projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    public Projeto findByNome(String nome);

    @Query(value = "SELECT DISTINCT p FROM projeto AS p JOIN usuario as u  ON p.idusuario = u.id " +
                   "JOIN rede as r ON p.idusuario = r.idusuarioorigem   " +
                   "WHERE r.idusuarioorigem = :usuarioId", nativeQuery = true)
    List<Projeto> findProjetosDosSeguidores(@Param("usuarioId") Long usuarioId);

    //long countProjetoByUsuario(String usuario);

}
