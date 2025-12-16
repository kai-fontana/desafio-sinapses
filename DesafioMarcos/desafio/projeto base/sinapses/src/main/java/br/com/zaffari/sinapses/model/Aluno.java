package main.java.br.com.zaffari.sinapses.model;

import java.lang.annotation.Inherited;

@Entity
@Table("alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricula;
    private String nome;
    private String turma;
}
