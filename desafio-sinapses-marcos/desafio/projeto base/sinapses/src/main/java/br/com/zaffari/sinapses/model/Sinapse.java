package br.com.zaffari.sinapses.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sinapse")
public class Sinapse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descricao;
    private String categoria;
    private LocalDate data;
    private String urlConteudo;

    public Sinapse(){
        
    }

    public int getId() {
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

    
}
