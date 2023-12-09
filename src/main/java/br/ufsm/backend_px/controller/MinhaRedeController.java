package br.ufsm.backend_px.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/minharede")
@Api(value = "Minha Rede", description = "API para tela de minha rede")
public class MinhaRedeController {
}
