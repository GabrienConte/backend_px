package br.ufsm.backend_px.model.tipolinguagem;

import br.ufsm.backend_px.service.TipoLinguagemService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TipoLinguagemRepository extends JpaRepository<TipoLinguagem, Long> {
    public TipoLinguagem getById(Long id);
    public Optional<TipoLinguagem> findById(Long id);
    @Query(value = "SELECT a.id  as id, a.nome as nome" +
            " FROM alunos a where a.idlinguagem =:id", nativeQuery = true)
    List<TipoLinguagemDTO> findTipoLinguagensByLinguagem(@Param("id") int id);
}