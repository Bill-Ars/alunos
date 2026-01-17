package com.seugestao.alunos.service;

import com.seugestao.alunos.entities.Curso;
import com.seugestao.alunos.repository.CursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepo repo;

    public void create(Curso curso){
        repo.save(curso);
    }

    public void update(Curso curso){
        repo.save(curso);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public Curso pegarPorId(Long id){
        return repo.findById(id).orElse(new Curso());
    }

    public List<Curso> listar(){
        return repo.findAll();
    }
}
