package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.config.Mapper;
import br.ufsm.backend_px.model.projeto.Projeto;
import br.ufsm.backend_px.model.projeto.ProjetoDTO;
import br.ufsm.backend_px.model.rede.Rede;
import br.ufsm.backend_px.model.usuario.Usuario;
import br.ufsm.backend_px.model.usuario.Usuario;
import br.ufsm.backend_px.service.ProjetoService;
import br.ufsm.backend_px.service.RedeService;
import br.ufsm.backend_px.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/minharede")
@Api(value = "Minha Rede", description = "API para tela de minha rede")
public class MinhaRedeController {
    private final ProjetoService service;
    private final UsuarioService serviceUsuario;
    private final RedeService serviceRede;
    private final Mapper mapper;

    public MinhaRedeController(ProjetoService service, UsuarioService serviceUsuario, RedeService serviceRede, Mapper mapper) {
        this.service = service;
        this.serviceUsuario = serviceUsuario;
        this.serviceRede = serviceRede;
        this.mapper = mapper;
    }

    @GetMapping
    @ApiOperation(value = "Listar projetos em uma rede", notes = "Lista todos os projetos cadastrados de uma rede.")
    public List<ProjetoDTO> index() {
        Usuario user = serviceUsuario.getUsuarioAutenticado();
        if(user != null)
            return this.service.obterProjetosDosSeguidores(user.getId()).stream()
                    .map(mapper::toProjetoDto)
                    .collect(toList());
        else
            return  null;
    }

    @PostMapping("/user/{followerUsuarioname}/follow/{followingUsuarioname}")
    public ResponseEntity<String> followUsuario(
            @PathVariable String followerUsuarioname,
            @PathVariable String followingUsuarioname) {

        Usuario follower = serviceUsuario.findUsuarioByUsername(followerUsuarioname);
        Usuario following = serviceUsuario.findUsuarioByUsername(followingUsuarioname);

        if (follower == null || following == null) {
            return ResponseEntity.notFound().build();
        }

        if (follower.equals(following)) {
            return ResponseEntity.badRequest().body("Não pode se seguir!");
        }

        Rede existingRede = serviceRede.findByUsuarioOrigemAndUsuarioDestino(follower.getId(), following.getId());
        if (existingRede != null) {
            return ResponseEntity.badRequest().body("Você já segue este usuário");
        }

        Rede follow = new Rede();
        follow.setUsuarioOrigem(serviceUsuario.findUsuario(follower.getId()));
        follow.setUsuarioDestino(serviceUsuario.findUsuario(following.getId()));

        serviceRede.salvar(follow);

        return ResponseEntity.ok("Seguiu");
    }

    @DeleteMapping("/user/{followerUsuarioname}/unfollow/{followingUsuarioname}")
    public ResponseEntity<String> unfollowUsuario(
            @PathVariable String followerUsuarioname,
            @PathVariable String followingUsuarioname) {

        Usuario follower = serviceUsuario.findUsuarioByUsername(followerUsuarioname);
        Usuario following = serviceUsuario.findUsuarioByUsername(followingUsuarioname);

        if (follower == null || following == null) {
            return ResponseEntity.notFound().build();
        }

        Rede existingRede = serviceRede.findByUsuarioOrigemAndUsuarioDestino(follower.getId(), following.getId());
        if (!(existingRede != null)) {
            return ResponseEntity.badRequest().body("Não está seguindo este usuário");
        }

        serviceRede.excluir(existingRede.getId());

        return ResponseEntity.ok("Parou de seguir com sucesso");
    }
}
