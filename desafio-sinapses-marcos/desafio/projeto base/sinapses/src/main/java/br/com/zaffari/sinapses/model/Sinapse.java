package br.com.zaffari.sinapses.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "sinapses")
public class Sinapse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "aluno_matricula", referencedColumnName = "matricula")
    private Aluno aluno;
    @NotBlank(message = "O título é obrigatório")
    private String titulo;
    private String descricao;
    @NotBlank(message = "A categoria é obrigatória")
    private String categoria;
    @Column(name = "data_criacao")
    private LocalDate dataCriacao;
    @Column(name = "ultima_atualizacao")
    private LocalDate ultimaAtualizacao;
    @NotBlank(message = "A URL do conteúdo é obrigatória")
    @Column(name = "url_conteudo")
    private String urlConteudo;

    public Sinapse(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDate ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getUrlConteudo() {
        return urlConteudo;
    }

    public void setUrlConteudo(String urlConteudo) {
        this.urlConteudo = urlConteudo;
    }

}
