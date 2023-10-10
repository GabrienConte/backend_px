package br.ufsm.backend_px.service;
import br.ufsm.backend_px.model.projeto.Projeto;
import br.ufsm.backend_px.model.projeto.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjetoService {
    private final ProjetoRepository repository;

    public ProjetoService(ProjetoRepository repository) {
        this.repository = repository;
    }
    public void cadastrar(Projeto projeto) {
        this.repository.save(projeto);
    }
    public List<Projeto> listar() {
        return this.repository.findAll();
    }
}
