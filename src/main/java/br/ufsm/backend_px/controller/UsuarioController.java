package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.model.usuario.DadosUsuario;
import br.ufsm.backend_px.model.usuario.Usuario;
import br.ufsm.backend_px.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@Api(value = "Usuário", description = "API para gerenciar usuários")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    @ApiOperation(value = "Criar usuário", notes = "Cria um novo usuário.")
    public ResponseEntity criar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder) {
        this.service.cadastrar(usuario);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Encontrar usuário por ID", notes = "Retorna um usuário com base no ID fornecido.")
    public Usuario findById(@PathVariable Long id) {
        return this.service.findUsuario(id);
    }

    @GetMapping
    @ApiOperation(value = "Listar todos os usuários", notes = "Lista todos os usuários cadastrados.")
    public List<DadosUsuario> findAll() {
        return this.service.findAllUsuarios();
    }
}
