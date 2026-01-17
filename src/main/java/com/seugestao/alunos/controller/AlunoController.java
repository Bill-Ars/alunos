package com.seugestao.alunos.controller;

import com.seugestao.alunos.entities.Aluno;
import com.seugestao.alunos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    public void create(@RequestBody Aluno aluno){
        service.create(aluno);
    }

    @GetMapping
    public List<Aluno> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Aluno pegarPorId(@PathVariable Long id){
        return service.pegarPorId(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Aluno aluno){
        service.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/curso/{cursoId}")
    public List<Aluno> listarPorCurso(@PathVariable Long cursoId){
        return service.listarPorCurso(cursoId);
    }
}
