package com.seugestao.alunos.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "aluno")
@NoArgsConstructor
@Getter
@Setter

@EqualsAndHashCode(of = "id")


public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Muitos alunos → Um curso
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Aluno(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
    }
}
