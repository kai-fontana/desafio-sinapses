package br.com.zaffari.sinapses.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String matricula;
    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;
    @OneToMany(mappedBy = "aluno")
    @JsonIgnore
    private List<Sinapse> sinapsesAluno;

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Sinapse> getSinapsesAluno() {
        return sinapsesAluno;
    }

    public void setSinapsesAluno(List<Sinapse> sinapsesAluno) {
        this.sinapsesAluno = sinapsesAluno;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    

}
