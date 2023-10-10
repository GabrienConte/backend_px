package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagem;
import br.ufsm.backend_px.model.linguagem.LinguagemDTO;
import br.ufsm.backend_px.service.TipoLinguagemService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tipoLinguagem")
@Api(value = "Tipo de Linguagem", description = "API para gerenciar tipos de linguagens")
public class TipoLinguagemController {
    private final TipoLinguagemService service;

    public TipoLinguagemController(TipoLinguagemService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    @ApiOperation(value = "Salvar tipo de linguagem", notes = "Cadastra um novo tipo de linguagem.")
    public ResponseEntity<TipoLinguagem> salvar(@RequestBody TipoLinguagem tipoLinguagem, UriComponentsBuilder uriBuilder) {
        this.service.salvar(tipoLinguagem);
        URI uri = uriBuilder.path("/tipoLinguagem/{id}").buildAndExpand(tipoLinguagem.getId()).toUri();
        return ResponseEntity.created(uri).body(tipoLinguagem);
    }

    @GetMapping
    @ApiOperation(value = "Listar tipos de linguagens", notes = "Lista todos os tipos de linguagens cadastrados.")
    public List<TipoLinguagem> listar() {
        return this.service.listar();
    }

    @GetMapping("/{id}/linguagens")
    @ApiOperation(value = "Listar linguagens por tipo de linguagem", notes = "Lista todas as linguagens de programação associadas a um tipo de linguagem.")
    public List<LinguagemDTO> listarLinguagens(@PathVariable int id) {
        return this.service.listarLinguagens(id);
    }
}