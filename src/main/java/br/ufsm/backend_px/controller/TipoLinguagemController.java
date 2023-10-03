package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import br.ufsm.backend_px.model.linguagem.LinguagemDTO;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagem;
import br.ufsm.backend_px.service.TipoLinguagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tipoLinguagem")
public class TipoLinguagemController {
    private final TipoLinguagemService service;

    public TipoLinguagemController(TipoLinguagemService service){
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TipoLinguagem> salvar(@RequestBody TipoLinguagem tipoLinguagem, UriComponentsBuilder uriBuilder){
        this.service.salvar(tipoLinguagem);
        URI uri = uriBuilder.path("/tipoLinguagem/{id}").buildAndExpand(tipoLinguagem.getId()).toUri();
        return ResponseEntity.created(uri).body(tipoLinguagem);
    }

    @GetMapping
    public List<TipoLinguagem> listar(){
        return this.service.listar();
    }

    @GetMapping("/{id}/linguagens")
    public List<LinguagemDTO> listarLinguagens(@PathVariable int id){
        return this.service.listarLinguagens(id);
    }

}
