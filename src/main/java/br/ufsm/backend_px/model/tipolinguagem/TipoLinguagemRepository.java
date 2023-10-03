package br.ufsm.backend_px.model.tipolinguagem;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import br.ufsm.backend_px.model.linguagem.LinguagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoLinguagemRepository  extends JpaRepository<TipoLinguagem, Long> {
    @Query(value = "SELECT l.id  as id, l.nome as nome" +
            " FROM linguagem l where a.idlinguagem =:id", nativeQuery = true)
    List<LinguagemDTO> findLinguagensByTipoLinguagem(@Param("id") int id);


}
