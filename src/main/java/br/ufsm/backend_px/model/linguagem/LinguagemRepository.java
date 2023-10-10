package br.ufsm.backend_px.model.linguagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface LinguagemRepository extends JpaRepository<Linguagem, Long> {

    public Linguagem getById(Long id);
    public Optional<Linguagem> findById(Long id);

    @Query(value = "SELECT *" +
            " FROM linguagem l WHERE l.id =:id", nativeQuery = true)
    List<LinguagemDTO> findLinguagensByTipoLinguagem(@Param("id") int id);

}
