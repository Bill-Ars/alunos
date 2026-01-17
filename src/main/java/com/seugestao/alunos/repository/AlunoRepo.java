package com.seugestao.alunos.repository;

import com.seugestao.alunos.entities.Aluno;
import com.seugestao.alunos.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepo extends JpaRepository<Aluno, Long> {

    // Buscar alunos por curso
    List<Aluno> findByCurso(Curso curso);
}
