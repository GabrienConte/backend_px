package br.ufsm.backend_px.service;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import br.ufsm.backend_px.model.linguagem.LinguagemRepository;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagem;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LinguagemService {
    private final LinguagemRepository repository;

    public LinguagemService(LinguagemRepository repository){
        this.repository = repository;
    }

    public void salvar(Linguagem linguagem){
        this.repository.save(linguagem);
    }


    public List<Linguagem> listar(){
        return this.repository.findAll();
    }

    public List<TipoLinguagemDTO> listarTipoLinguagens(int idLinguagem){
        return this.repository.findTipoLinguagensByLinguagem(idLinguagem);
    }
}
