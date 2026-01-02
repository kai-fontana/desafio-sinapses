package br.com.zaffari.sinapses.dtos;

import java.time.LocalDate;

public record ResponseSinapse(long id, String alunoMatricula, String titulo, 
    String descricao, String categoria, LocalDate dataCriacao, LocalDate ultimaAtualizacao, 
    String urlConteudo) {

}