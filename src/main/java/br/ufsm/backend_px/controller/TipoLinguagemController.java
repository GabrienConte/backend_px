package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.model.linguagem.Linguagem;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagem;
import br.ufsm.backend_px.model.tipolinguagem.TipoLinguagemDTO;
import br.ufsm.backend_px.service.TipoLinguagemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/tipoLinguagem")
public class TipoLinguagemController {
}
    private final TipoLinguagemService service;
    public TipoLinguagemController(TipoLinguagemService service){
        this.service = service;
    }
    @PostMapping("/print-json")
    public void printJSon(@RequestBody String json){
        System.out.println(json);
    }

    @GetMapping("/{id}")
    public TipoLinguagem tipoLinguagem(@PathVariable Long id){
        return this.service.findById(id);
    }
    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid TipoLinguagem tipoLinguagem, UriComponentsBuilder uriBuilder){

        this.service.salvar(tipoLinguagem);
        //monta a URI da aplicação dinamicamente
        URI uri = uriBuilder.path("/tipoLinguagem/{id}").buildAndExpand(tipoLinguagem.getId()).toUri();
        //created(uri) irá colocar no cabeçalho da requisição da resposta
        // o parâmetro Location com a URI de acesso ao recurso criado
        return ResponseEntity.created(uri).body(tipoLinguagem);
    }


    @GetMapping
    public ResponseEntity<List<TipoLinguagem>> listar(){
        return ResponseEntity.ok(this.service.listar());
    }


    /*
     ATUALIZAR DEVE DEVOLVER O RECURSO ATUALIZADO
     Mas não é boa prática devolver a entidade JPA no controler;

    * */
@PutMapping
@Transactional
public ResponseEntity atualizar(@RequestBody TipoLinguagem tipoLinguagem){
    this.service.atualizar(tipoLinguagem);
    return ResponseEntity.ok(tipoLinguagem);
}

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/atribuir-linguagem")
    @Transactional
    public ResponseEntity vincularLinguagem(@PathVariable Long id, @RequestBody Linguagem linguagem){
        return ResponseEntity.ok(this.service.atribuirLinguagem(id, linguagem));
    }

    @GetMapping("/linguagem/{id}")
    public List<TipoLinguagemDTO> listarTipoLinguagens(@PathVariable int id){
        return this.service.findByTipoLinguagensPorLinguagem(id);
    }

}


