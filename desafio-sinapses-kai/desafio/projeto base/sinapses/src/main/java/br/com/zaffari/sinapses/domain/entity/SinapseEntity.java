package br.com.zaffari.sinapses.domain.entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "sinapses")
@Table(name = "sinapses")
public class SinapseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_id")
    @SequenceGenerator (
        name="gerador_id",
        sequenceName="sinapses_id_seq",
        allocationSize=1

    )
    protected Long id;

    protected Integer matricula;

    /*@ManyToOne
    protected Aluno aluno;*/

    protected String titulo;
    protected String descricao;
    protected String categoria;

    protected LocalDate dataCriacao;
    protected LocalDate dataAtualizacao;
    protected Boolean ativo;

    protected String link;
    protected String keyword;

    public SinapseEntity() {}

    public SinapseEntity(Long id, Integer matricula, String titulo, String descricao, String categoria, LocalDate dataCriacao, LocalDate dataAtualizacao, String link, String keyword, Boolean ativo) {
        this.id = id;
        this.matricula = matricula;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.link = link;
        this.keyword = keyword;
        this.ativo = ativo;
    }


    public SinapseEntity(SinapseRequestDTO requestSinapse){
        this.id = requestSinapse.id();
        this.titulo = requestSinapse.titulo();
        this.descricao = requestSinapse.descricao();
        this.matricula = requestSinapse.matricula();
        this.categoria = requestSinapse.categoria();
        this.dataCriacao  = requestSinapse.dataCriacao();
        this.dataAtualizacao  = requestSinapse.dataAtualizacao();
        this.link = requestSinapse.link();
        this.keyword = requestSinapse.keyword();
        this.ativo = requestSinapse.ativo();
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Integer getMatricula() {
        return matricula;
    }


    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
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


    public void setData(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }


    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }


    public String getLink() {
        return link;
    }


    public void setLink(String link) {
        this.link = link;
    }


    public String getKeyword() {
        return keyword;
    }


    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}