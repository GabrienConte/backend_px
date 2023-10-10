package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.model.projeto.Projeto;
import br.ufsm.backend_px.service.ProjetoService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projeto")
@Api(value = "Projeto", description = "API para gerenciar projetos")
public class ProjetoController {
    private final ProjetoService service;

    public ProjetoController(ProjetoService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    @ApiOperation(value = "Salvar projeto", notes = "Cadastra um novo projeto.")
    public ResponseEntity<Projeto> salvar(@RequestBody Projeto projeto, UriComponentsBuilder uriBuilder) {
        this.service.cadastrar(projeto);
        URI uri = uriBuilder.path("/projeto/{id}").buildAndExpand(projeto.getId()).toUri();
        return ResponseEntity.created(uri).body(projeto);
    }

    @GetMapping
    @ApiOperation(value = "Listar projetos", notes = "Lista todos os projetos cadastrados.")
    public List<Projeto> listar() {
        return this.service.listar();
    }
}
