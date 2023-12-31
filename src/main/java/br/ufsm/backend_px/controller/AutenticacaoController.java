package br.ufsm.backend_px.controller;

import br.ufsm.backend_px.infra.security.TokenServiceJWT;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Api(value = "Autenticação", description = "API para autenticação de usuários")
public class AutenticacaoController {
    private final AuthenticationManager manager;
    private final TokenServiceJWT tokenServiceJWT;

    public AutenticacaoController(AuthenticationManager manager, TokenServiceJWT tokenServiceJWT) {
        this.manager = manager;
        this.tokenServiceJWT = tokenServiceJWT;
    }

    @PostMapping()
    @ApiOperation(value = "Efetuar login", notes = "Autentica o usuário com base nas credenciais fornecidas e retorna um token JWT.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Login bem-sucedido. O token JWT é retornado."),
            @ApiResponse(code = 400, message = "Erro ao efetuar login. Uma mensagem de erro é retornada.")
    })
    public ResponseEntity efetuarLogin(
            @ApiParam(value = "Dados de autenticação do usuário", required = true) @RequestBody @Valid DadosAutenticacao dados) {
        try {
            Authentication autenticado = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            Authentication at = manager.authenticate(autenticado);

            User user = (User) at.getPrincipal();
            String token = this.tokenServiceJWT.gerarToken(user);

            return ResponseEntity.ok().body(new DadosTokenJWT(token));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private record DadosTokenJWT(String token) {
    }

    private record DadosAutenticacao(String login, String senha) {
    }
}
