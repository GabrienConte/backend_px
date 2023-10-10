package br.ufsm.backend_px.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ExemploController {

    @GetMapping()
    @ApiOperation(value = "Retorna uma saudação simples", notes = "Retorna a saudação 'Hello, Swagger!'")
    public String sayHello() {
        return "Hello, Swagger!";
    }
}