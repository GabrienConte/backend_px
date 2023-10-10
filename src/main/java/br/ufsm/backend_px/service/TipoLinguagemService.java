package br.ufsm.backend_px.service;

import br.ufsm.backend_px.model.linguagem.LinguagemDTO;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagem;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoLinguagemService {
    private final TipoLinguagemRepository repository;

    public TipoLinguagemService(TipoLinguagemRepository repository){
        this.repository = repository;
    }

    public void salvar(TipoLinguagem tipoLinguagem){
        this.repository.save(tipoLinguagem);
    }


    public List<TipoLinguagem> listar(){
        return this.repository.findAll();
    }

    public List<LinguagemDTO> listarLinguagens(int idtiposLinguagens){
        return this.repository.findLinguagensByTipoLinguagem(idtiposLinguagens);
    }

}
