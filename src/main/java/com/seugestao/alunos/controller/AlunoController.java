package com.seugestao.alunos.controller;

import com.seugestao.alunos.dto.aluno.AlunoRequestDTO;
import com.seugestao.alunos.dto.aluno.AlunoResponseDTO;
import com.seugestao.alunos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    // ==============================
    // Criar aluno
    // ==============================
    @PostMapping
    public void create(@RequestBody AlunoRequestDTO dto) {
        service.create(dto);
    }

    // ==============================
    // Listar todos os alunos
    // ==============================
    @GetMapping
    public List<AlunoResponseDTO> listar() {
        return service.listar();
    }


    // ==============================
    // Buscar aluno por ID
    // ==============================
    @GetMapping("/{id}")
    public AlunoResponseDTO pegarPorId(@PathVariable Long id) {
        return service.pegarPorId(id);
    }

    // ==============================
    // Atualizar aluno
    // ==============================
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody AlunoRequestDTO dto) {
        service.update(id, dto);
    }

    // ==============================
    // Deletar aluno
    // ==============================
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // ==============================
    // Listar alunos por curso
    // ==============================
    @GetMapping("/curso/{cursoId}")
    public List<AlunoResponseDTO> listarPorCurso(@PathVariable Long cursoId) {
        return service.listarPorCurso(cursoId);
    }
}
