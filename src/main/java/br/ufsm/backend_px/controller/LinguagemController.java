package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagem;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagemDTO;
import br.ufsm.backend_px.service.LinguagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/linguagem")
public class LinguagemController {
    private final LinguagemService service;

    public LinguagemController(LinguagemService service){
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Linguagem> salvar(@RequestBody Linguagem linguagem, UriComponentsBuilder uriBuilder){
        this.service.salvar(linguagem);
        URI uri = uriBuilder.path("/linguagem/{id}").buildAndExpand(linguagem.getId()).toUri();
        return ResponseEntity.created(uri).body(linguagem);
    }

    @GetMapping
    public List<Linguagem> listar(){
        return this.service.listar();
    }

    @GetMapping("/{id}/tipoLinguagens")
    public List<TipoLinguagemDTO> listarTipoLinguagens(@PathVariable int id){
        return this.service.listarTipoLinguagens(id);
    }

}
