package com.seugestao.alunos.service;

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

    public void create(Aluno aluno){
        repo.save(aluno);
    }

    public void update(Long id, Aluno alunoAtualizado){
        Aluno existente = repo.findById(id).orElseThrow();
        existente.setNome(alunoAtualizado.getNome());
        existente.setCurso(alunoAtualizado.getCurso());
        repo.save(existente);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public Aluno pegarPorId(Long id){
        return repo.findById(id).orElse(new Aluno());
    }

    public List<Aluno> listar(){
        return repo.findAll();
    }

    public List<Aluno> listarPorCurso(Long cursoId){
        Curso curso = cursoRepo.findById(cursoId).orElseThrow();
        return repo.findByCurso(curso);
    }
}
