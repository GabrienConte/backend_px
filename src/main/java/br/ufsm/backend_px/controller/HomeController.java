package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.config.Mapper;
import br.ufsm.backend_px.model.projeto.ProjetoDTO;
import br.ufsm.backend_px.service.ProjetoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/home")
@Api(value = "Home", description = "API para tela home")
public class HomeController {
    private final ProjetoService service;
    private final Mapper mapper;

    public HomeController(ProjetoService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
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
}
