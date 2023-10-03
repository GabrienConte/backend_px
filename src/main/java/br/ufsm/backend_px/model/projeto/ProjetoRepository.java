package br.ufsm.backend_px.model.projeto;

import br.ufsm.backend_px.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    public Projeto findByProjeto(String nome);
}
