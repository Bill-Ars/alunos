package com.seugestao.alunos.controller;

import com.seugestao.alunos.dto.curso.CursoRequestDTO;
import com.seugestao.alunos.dto.curso.CursoResponseDTO;
import com.seugestao.alunos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService service;

    // ==============================
    // Criar curso
    // ==============================
    @PostMapping
    public void create(@RequestBody CursoRequestDTO dto) {
        service.create(dto);
    }

    // ==============================
    // Listar todos os cursos
    // ==============================
    @GetMapping
    public List<CursoResponseDTO> listar() {
        return service.listar();
    }

    // ==============================
    // Buscar curso por ID
    // ==============================
    @GetMapping("/{id}")
    public CursoResponseDTO pegarPorId(@PathVariable Long id) {
        return service.pegarPorId(id);
    }

    // ==============================
    // Atualizar curso
    // ==============================
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CursoRequestDTO dto) {
        service.update(id, dto);
    }

    // ==============================
    // Deletar curso
    // ==============================
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
