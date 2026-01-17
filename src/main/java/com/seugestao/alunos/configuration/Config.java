package com.seugestao.alunos.configuration;

import com.seugestao.alunos.entities.Aluno;
import com.seugestao.alunos.entities.Curso;
import com.seugestao.alunos.repository.AlunoRepo;
import com.seugestao.alunos.repository.CursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

    @Autowired
    private CursoRepo cursoRepo;

    @Autowired
    private AlunoRepo alunoRepo;

    @Override
    public void run(String... args) throws Exception {
        Curso c1 = new Curso("Engenharia Civil");
        Curso c2 = new Curso("Computer Applications");
        Curso c3 = new Curso("Medicina Geral");
        Curso c4 = new Curso("Enhenharia Ferroviaria");

        cursoRepo.save(c1);
        cursoRepo.save(c2);
        cursoRepo.save(c3);
        cursoRepo.save(c4);



        Aluno a1 = new Aluno("Carlos", c1);
        Aluno a2 = new Aluno("Bill", c2);
        Aluno a3 = new Aluno("Ana", c1);
        Aluno a4 = new Aluno("Joao", c3);
        Aluno a5 = new Aluno("Valentim", c1);
        Aluno a6 = new Aluno("Benjamin", c2);
        Aluno a7 = new Aluno("Belinda", c1);


        alunoRepo.save(a1);
        alunoRepo.save(a2);
        alunoRepo.save(a3);
        alunoRepo.save(a4);
        alunoRepo.save(a5);
        alunoRepo.save(a6);
        alunoRepo.save(a7);
    }
}
