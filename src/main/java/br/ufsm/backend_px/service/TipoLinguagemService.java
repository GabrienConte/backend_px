package br.ufsm.backend_px.service;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagem;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagemDTO;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoLinguagemService {
    private TipoLinguagemRepository repository;
    public TipoLinguagemService(TipoLinguagemRepository repository){
        this.repository = repository;
    }
    public void salvar(TipoLinguagem tipoLinguagem){
        this.repository.save(tipoLinguagem);
    }
    public List<TipoLinguagem> listar(){
        return this.repository.findAll();
    }
    public TipoLinguagem findById(Long id){
        return this.repository.findById(id).get();
    }
    public void atualizar(TipoLinguagem tipoLinguagem){
        TipoLinguagem tl = this.repository.getReferenceById(tipoLinguagem.getId());
        tl.setNome(tipoLinguagem.getNome());
    }
    public void excluir(Long id){
        this.repository.deleteById(id);
    }
    public String atribuirLinguagem(Long idTipoLinguagem, Linguagem linguagem){
        TipoLinguagem tipoLinguagem = this.repository.getReferenceById(idTipoLinguagem);
        tipoLinguagem.setLinguagem(linguagem);
        return "LINGUAGEM ATRIBUÍDA COM SUCESSO!!";
    }
   /* public List<TipoLinguagemDTO> findByTipoLinguagemPorLinguagem(int id){
        return this.repository.findTipoLinguagemByLinguagem(id);
    }*/
}
