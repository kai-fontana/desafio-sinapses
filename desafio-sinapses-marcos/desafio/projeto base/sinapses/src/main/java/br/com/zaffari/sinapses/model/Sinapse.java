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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

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
    @NotNull(message = "A data é obrigatória")
    @PastOrPresent(message = "A data não pode estar no futuro")
    private LocalDate data;
    @NotBlank(message = "A URL do conteúdo é obrigatória")
    @Column(name = "url_conteudo")
    private String urlConteudo;

    public Sinapse(){
    }

    public long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getCategoria() {
        return categoria;
    }
    public LocalDate getData() {
        return data;
    }
    public String getUrlConteudo() {
        return urlConteudo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setUrlConteudo(String urlConteudo) {
        this.urlConteudo = urlConteudo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
}

