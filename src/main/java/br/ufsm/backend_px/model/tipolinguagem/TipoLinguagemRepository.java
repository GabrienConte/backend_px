package br.ufsm.backend_px.model.tipolinguagem;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import br.ufsm.backend_px.model.linguagem.LinguagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoLinguagemRepository  extends JpaRepository<TipoLinguagem, Long> {
    @Query(value = "SELECT tl.id  as id, tl.nome as nome" +
            " FROM tipolinguagem tl where tl.id =:id", nativeQuery = true)
    List<LinguagemDTO> findLinguagensByTipoLinguagem(@Param("id") int id);


}
