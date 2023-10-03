package br.ufsm.backend_px.controller;
import br.ufsm.backend_px.service.LinguagemService;

import br.ufsm.backend_px.service.TipoLinguagemService;
import br.ufsm.backend_px.model.linguagem.Linguagem;
import br.ufsm.backend_px.model.linguagem.LinguagemDTO;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagem;
import br.ufsm.backend_px.service.LinguagemService;
import jakarta.validation.Valid;
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
    @PostMapping("/print-json")
    public void printJSon(@RequestBody String json){
        System.out.println(json);
    }

    @GetMapping("/{id}")
    public Linguagem linguagem(@PathVariable Long id){
        return this.service.findById(id);
    }


    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid Linguagem linguagem, UriComponentsBuilder uriBuilder){

        this.service.salvar(linguagem);
        URI uri = uriBuilder.path("/linguagem/{id}").buildAndExpand(linguagem.getId()).toUri();
        return ResponseEntity.created(uri).body(linguagem);
    }


    @GetMapping
    public ResponseEntity<List<Linguagem>> listar(){
        return ResponseEntity.ok(this.service.listar());
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Linguagem linguagem){
        this.service.atualizar(linguagem);
        return ResponseEntity.ok(linguagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/atribuir-linguagem")
    @Transactional
    public ResponseEntity vincularLinguagem(@PathVariable Long id, @RequestBody TipoLinguagem tipoLinguagem){
        return ResponseEntity.ok(this.service.atribuirTipoLinguagem(id, tipoLinguagem));
    }

    @GetMapping("/tipoLinguagem/{id}")
    public List<LinguagemDTO> listarLinguagens(@PathVariable int id){
        return this.service.findByLinguagensPorTipoLinguagem(id);
    }

}
