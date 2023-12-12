package br.ufsm.backend_px.service;

import br.ufsm.backend_px.model.rede.Rede;
import br.ufsm.backend_px.model.rede.RedeRepository;
import br.ufsm.backend_px.model.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RedeService {
    private RedeRepository repository;
    public RedeService(RedeRepository repository){
        this.repository = repository;
    }
    public void salvar(Rede rede){
        this.repository.save(rede);
    }
    public List<Rede> listar(){
        return this.repository.findAll();
    }
    public Rede findById(Long id){
        return this.repository.findById(id).get();
    }

    public void excluir(Long id){
        this.repository.deleteById(id);
    }

    public Rede findByUsuarioOrigemAndUsuarioDestino(Long usuarioOrigem, Long usuarioDestino)
    {
        return this.repository.findRedeByUsuarioOrigemAndUsuarioDestino( usuarioOrigem, usuarioDestino);
    }
}
