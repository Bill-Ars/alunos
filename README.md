# Sistema de Gestão de Alunos

Projeto backend desenvolvido com Spring Boot para praticar conceitos fundamentais de JPA e arquitetura em camadas.

## Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## Funcionalidades
- CRUD de Cursos
- CRUD de Alunos
- Relacionamento OneToMany / ManyToOne
- Buscar alunos por curso
- Atualizar aluno sem perder o curso
- Carga inicial de dados com profile `test`

## Endpoints principais
- GET /aluno
- POST /aluno
- PUT /aluno/{id}
- DELETE /aluno/{id}
- GET /aluno/curso/{cursoId}
- GET /curso

## Observações
Projeto desenvolvido com foco em boas práticas de backend e modelagem de dados.
