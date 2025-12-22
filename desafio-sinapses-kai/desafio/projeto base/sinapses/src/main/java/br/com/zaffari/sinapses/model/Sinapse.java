package br.com.zaffari.sinapses.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "sinapses")
@Table(name = "sinapses")
public class Sinapse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @Column
    protected Integer matriculaAluno;

    @Column
    protected String titulo;

    @Column
    protected String descricao;

    @Column
    protected String categoria;

    @Column
    protected LocalDate dataDeAprendizado;

    @Column
    protected String fonteDoAprendizado;


    public Sinapse(Integer id, Integer matriculaAluno, String titulo, String descricao, String categoria, LocalDate dataDeAprendizado, String fonteDoAprendizado) {
        this.id = id;
        this.matriculaAluno = matriculaAluno;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataDeAprendizado = dataDeAprendizado;
        this.fonteDoAprendizado = fonteDoAprendizado;
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

    public LocalDate getDataDeAprendizado() {
        return dataDeAprendizado;
    }

    public void setDataDeAprendizado(LocalDate dataDeAprendizado) {
        this.dataDeAprendizado = dataDeAprendizado;
    }

    public String getFonteDoAprendizado() {
        return fonteDoAprendizado;
    }

    public void setFonteDoAprendizado(String fonteDoAprendizado) {
        this.fonteDoAprendizado = fonteDoAprendizado;
    }
}