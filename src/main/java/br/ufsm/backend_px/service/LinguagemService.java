package br.ufsm.backend_px.service;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import br.ufsm.backend_px.model.linguagem.LinguagemDTO;
import br.ufsm.backend_px.model.linguagem.LinguagemRepository;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagem;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinguagemService {
    private LinguagemRepository repository;
    public LinguagemService(LinguagemRepository repository){
        this.repository = repository;
    }
    public void salvar(Linguagem linguagem){
        this.repository.save(linguagem);
    }
    public List<Linguagem> listar(){
        return this.repository.findAll();
    }
    public Linguagem findById(Long id){
        return this.repository.findById(id).get();
    }
    public void atualizar(Linguagem linguagem){
        Linguagem l = this.repository.getReferenceById(linguagem.getId());
        l.setNome(linguagem.getNome());
    }
    public void excluir(Long id){
        this.repository.deleteById(id);
    }

    public String atribuirTipoLinguagem(Long idLinguagem, TipoLinguagem tipoLinguagem){
        Linguagem linguagem = this.repository.getReferenceById(idLinguagem);
        linguagem.setTipoLinguagem(tipoLinguagem);
        return "Linguagem atribuída!!!!!!!!";
    }

    public List<LinguagemDTO> findByLinguagensPorTipoLinguagem(int id){
        return this.repository.findLinguagensByTipoLinguagem(id);
    }
}
