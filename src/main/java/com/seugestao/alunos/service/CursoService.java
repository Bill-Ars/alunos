package com.seugestao.alunos.service;


import com.seugestao.alunos.dto.curso.CursoRequestDTO;
import com.seugestao.alunos.dto.curso.CursoResponseDTO;
import com.seugestao.alunos.entities.Curso;
import com.seugestao.alunos.repository.CursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepo repo;

    // ==============================
    // Criar curso
    // ==============================
    public void create(CursoRequestDTO dto){
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        repo.save(curso);
    }

    // ==============================
    // Atualizar curso
    // ==============================
    public void update(Long id, CursoRequestDTO dto){
        Curso curso = repo.findById(id).orElseThrow();
        curso.setNome(dto.getNome());
        repo.save(curso);
    }

    // ==============================
    // Deletar curso
    // ==============================
    public void delete(Long id){
        repo.deleteById(id);
    }

    // ==============================
    // Buscar curso por ID → DTO
    // ==============================
    public CursoResponseDTO pegarPorId(Long id){
        Curso curso = repo.findById(id).orElseThrow();
        return toDTO(curso);
    }

    // ==============================
    // Listar cursos → DTO
    // ==============================
    public List<CursoResponseDTO> listar(){
        return repo.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // ==============================
    // Conversão Entity → DTO
    // ==============================
    private CursoResponseDTO toDTO(Curso curso){
        return new CursoResponseDTO(
                curso.getId(),
                curso.getNome()
        );
    }
}
