package br.com.zaffari.sinapses.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import java.time.LocalDate;

import java.util.List;

@Entity(name = "sinapses")
@Table(name = "sinapses")
public class Sinapse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @JsonProperty("matricula_aluno")
    protected Integer matriculaAluno;
    protected String titulo;
    protected String descricao;
    protected String categoria;

    @JsonProperty("data_de_estudo")
    protected LocalDate dataDeEstudo;

    @JsonProperty("fonte_de_estudo")
    protected String fonteDeEstudo;

    @JsonProperty("palavras_chave")
    protected List<String> palavrasChave;

    public Sinapse(Integer id, Integer matriculaAluno, String titulo, String descricao, String categoria, LocalDate dataDeEstudo, String fonteDeEstudo, List<String> palavrasChave) {
        this.id = id;
        this.matriculaAluno = matriculaAluno;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataDeEstudo = dataDeEstudo;
        this.fonteDeEstudo = fonteDeEstudo;
        this.palavrasChave = palavrasChave;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(Integer matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataDeEstudo() {
        return dataDeEstudo;
    }

    public void setDataDeAprendizado(LocalDate dataDeEstudo) {
        this.dataDeEstudo = dataDeEstudo;
    }

    public String getFonteDoEstudo() {
        return fonteDeEstudo;
    }

    public void setFonteDoAprendizado(String fonteDeEstudo) {
        this.fonteDeEstudo = fonteDeEstudo;
    }
}