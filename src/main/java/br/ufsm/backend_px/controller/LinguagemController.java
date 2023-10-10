package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import br.ufsm.backend_px.model.linguagem.LinguagemDTO;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagem;
import br.ufsm.backend_px.service.LinguagemService;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/linguagem")
@Api(value = "Linguagem", description = "API para gerenciar linguagens de programação")
public class LinguagemController {
    private final LinguagemService service;

    public LinguagemController(LinguagemService service) {
        this.service = service;
    }

    @PostMapping("/print-json")
    @ApiOperation(value = "Imprimir JSON", notes = "Imprime o JSON recebido como entrada.")
    public void printJSon(@RequestBody String json) {
        System.out.println(json);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obter linguagem por ID", notes = "Retorna uma linguagem de programação com base no ID fornecido.")
    public Linguagem linguagem(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping
    @Transactional
    @ApiOperation(value = "Salvar linguagem", notes = "Salva uma nova linguagem de programação.")
    public ResponseEntity salvar(@RequestBody @Valid Linguagem linguagem, UriComponentsBuilder uriBuilder) {
        this.service.salvar(linguagem);
        URI uri = uriBuilder.path("/linguagem/{id}").buildAndExpand(linguagem.getId()).toUri();
        return ResponseEntity.created(uri).body(linguagem);
    }

    @GetMapping
    @ApiOperation(value = "Listar linguagens", notes = "Lista todas as linguagens de programação disponíveis.")
    public ResponseEntity<List<Linguagem>> listar() {
        return ResponseEntity.ok(this.service.listar());
    }

    @PutMapping
    @Transactional
    @ApiOperation(value = "Atualizar linguagem", notes = "Atualiza uma linguagem de programação existente.")
    public ResponseEntity atualizar(@RequestBody Linguagem linguagem) {
        this.service.atualizar(linguagem);
        return ResponseEntity.ok(linguagem);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Excluir linguagem", notes = "Exclui uma linguagem de programação com base no ID fornecido.")
    public ResponseEntity deletar(@PathVariable Long id) {
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/atribuir-linguagem")
    @Transactional
    @ApiOperation(value = "Vincular linguagem", notes = "Vincula uma linguagem de programação a um tipo de linguagem.")
    public ResponseEntity vincularLinguagem(@PathVariable Long id, @RequestBody TipoLinguagem tipoLinguagem) {
        return ResponseEntity.ok(this.service.atribuirTipoLinguagem(id, tipoLinguagem));
    }

    @GetMapping("/tipoLinguagem/{id}")
    @ApiOperation(value = "Listar linguagens por tipo de linguagem", notes = "Lista todas as linguagens de programação associadas a um tipo de linguagem.")
    public List<LinguagemDTO> listarLinguagens(@PathVariable int id) {
        return this.service.findByLinguagensPorTipoLinguagem(id);
    }
}
