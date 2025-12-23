package br.com.zaffari.sinapses.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "sinapses")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricula;
    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;
    @OneToMany(mappedBy = "aluno")
    private List<Sinapse> sinapsesAluno;

    public Aluno() {
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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
    
    

}
