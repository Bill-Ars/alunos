package com.seugestao.alunos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

   @RequestMapping("/")
    public String greet() {
        return "Seja bem benvindo/a ao seu sistema de gestao academica!";
    }
}
