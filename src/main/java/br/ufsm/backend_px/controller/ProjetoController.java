package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.config.Mapper;
import br.ufsm.backend_px.model.linguagem.Linguagem;
import br.ufsm.backend_px.model.projeto.Projeto;
import br.ufsm.backend_px.model.projeto.ProjetoDTO;
import br.ufsm.backend_px.service.ProjetoService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/projeto")
@Api(value = "Projeto", description = "API para gerenciar projetos")
public class ProjetoController {
    private final ProjetoService service;
    private final Mapper mapper;

    public ProjetoController(ProjetoService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
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
    public List<ProjetoDTO> index() {
        System.out.println(this.service.listar());
        return this.service.listar()
                .stream()
                .map(mapper::toProjetoDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obter projeto por ID", notes = "Retorna um projeto com base no ID fornecido.")
    public ProjetoDTO obterProjeto(@PathVariable Long id) {
        Projeto projeto = this.service.findById(id);
        ProjetoDTO projetoDTO = mapper.toProjetoDto(projeto);
        return projetoDTO;
    }
}
