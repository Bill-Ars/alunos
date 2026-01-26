package com.seugestao.alunos.dto.aluno;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private Long cursoId;
    private String cursoNome;

}
//Definimos o JSON da API