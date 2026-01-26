package com.seugestao.alunos.service;

import com.seugestao.alunos.dto.aluno.AlunoRequestDTO;
import com.seugestao.alunos.dto.aluno.AlunoResponseDTO;
import com.seugestao.alunos.entities.Aluno;
import com.seugestao.alunos.entities.Curso;
import com.seugestao.alunos.repository.AlunoRepo;
import com.seugestao.alunos.repository.CursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AlunoService {

    @Autowired
    private AlunoRepo repo;

    @Autowired
    private CursoRepo cursoRepo;

    // ==============================
    // Criar um aluno (RequestDTO → Entity)
    // ==============================
    public void create(AlunoRequestDTO dto) {
        // 1️⃣ Buscar o curso pelo ID
        Curso curso = cursoRepo.findById(dto.getCursoId())
                .orElseThrow(); // pode se personalizar a exceção

        // 2️⃣ Criar a entidade Aluno
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setCurso(curso);

        // 3️⃣ Salvar no banco
        repo.save(aluno);
    }

    // ==============================
    // Atualizar um aluno
    // ==============================
    public void update(Long id, AlunoRequestDTO dto) {
        Aluno existente = repo.findById(id).orElseThrow();

        // Atualiza apenas os campos permitidos
        existente.setNome(dto.getNome());

        // Atualiza o curso
        Curso curso = cursoRepo.findById(dto.getCursoId())
                .orElseThrow();
        existente.setCurso(curso);

        repo.save(existente);
    }

    // ==============================
    // Deletar aluno
    // ==============================

    public void delete(Long id){
        repo.deleteById(id);
    }


    // ==============================
    // Buscar aluno por ID → retorna DTO
    // ==============================
    public AlunoResponseDTO pegarPorId(Long id){
        Aluno aluno = repo.findById(id).orElseThrow();
        return toDTO(aluno);
    }


    // ==============================
    // Listar todos os alunos → retorna DTO
    // ==============================
    public List<AlunoResponseDTO> listar(){
        return repo.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }


    // ==============================
    // Listar alunos de um curso específico → retorna DTO
    // ==============================
    public List<AlunoResponseDTO> listarPorCurso(Long cursoId){
        // 1️⃣ Buscar curso
        Curso curso = cursoRepo.findById(cursoId).orElseThrow();

        // 2️⃣ Buscar alunos do curso
        List<Aluno> alunosDoCurso = repo.findByCurso(curso);

        // 3️⃣ Converter para DTO
        return alunosDoCurso.stream()
                .map(this::toDTO)
                .toList();
    }

    // ==============================
    // Conversão Entity → DTO
    // ==============================
    private AlunoResponseDTO toDTO(Aluno aluno) {
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCurso().getId(),
                aluno.getCurso().getNome()
        );
    }
}
