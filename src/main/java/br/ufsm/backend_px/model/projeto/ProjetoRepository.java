package br.ufsm.backend_px.model.projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    public Projeto findByNome(String nome);

    //long countProjetoByUsuario(String usuario);

}
