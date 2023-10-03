package br.ufsm.backend_px.model.linguagem;

import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LinguagemRepository extends JpaRepository<Linguagem, Long> {
    @Query(value = "SELECT a.id  as id, a.nome as nome" +
            " FROM alunos a where a.idlinguagem =:id", nativeQuery = true)
    List<TipoLinguagemDTO> findTipoLinguagensByLinguagem(@Param("id") int id);
}
