package com.seugestao.alunos.repository;

import com.seugestao.alunos.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepo extends JpaRepository<Curso, Long> {
}
