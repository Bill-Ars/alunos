package com.seugestao.alunos.controller;

import com.seugestao.alunos.entities.Curso;
import com.seugestao.alunos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    public void create(@RequestBody Curso curso){
        service.create(curso);
    }

    @GetMapping
    public List<Curso> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Curso pegarPorId(@PathVariable Long id){
        return service.pegarPorId(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Curso curso){
        service.update(curso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
