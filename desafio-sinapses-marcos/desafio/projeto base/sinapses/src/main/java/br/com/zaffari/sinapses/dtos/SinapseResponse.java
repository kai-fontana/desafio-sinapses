package br.com.zaffari.sinapses.dtos;

import java.time.LocalDate;

public record SinapseResponse(long id, String matricula, String titulo, 
    String descricao, String categoria, LocalDate dataCriacao, LocalDate ultimaAtualizacao, 
    String urlConteudo) {

}