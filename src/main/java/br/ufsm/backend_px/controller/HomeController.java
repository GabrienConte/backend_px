package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.model.projeto.Projeto;
import br.ufsm.backend_px.service.ProjetoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@Api(value = "Home", description = "API para tela home")
public class HomeController {
    private final ProjetoService service;

    public HomeController(ProjetoService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Listar projetos", notes = "Lista todos os projetos cadastrados.")
    public List<Projeto> index() {
        return this.service.listar();
    }
}
