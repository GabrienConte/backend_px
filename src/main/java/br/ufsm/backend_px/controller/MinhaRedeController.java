package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.model.projeto.Projeto;
import br.ufsm.backend_px.model.usuario.DadosUsuario;
import br.ufsm.backend_px.model.usuario.Usuario;
import br.ufsm.backend_px.service.ProjetoService;
import br.ufsm.backend_px.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/minharede")
@Api(value = "Minha Rede", description = "API para tela de minha rede")
public class MinhaRedeController {
    private final ProjetoService service;
    private final UsuarioService serviceUser;

    public MinhaRedeController(ProjetoService service, UsuarioService serviceUser) {
        this.service = service;
        this.serviceUser = serviceUser;
    }

    @GetMapping
    @ApiOperation(value = "Listar projetos em uma rede", notes = "Lista todos os projetos cadastrados de uma rede.")
    public List<Projeto> index() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        DadosUsuario user = serviceUser.findUsuarioByUsername(currentPrincipalName);

        return this.service.obterProjetosDosSeguidores(user.id());
    }
}
