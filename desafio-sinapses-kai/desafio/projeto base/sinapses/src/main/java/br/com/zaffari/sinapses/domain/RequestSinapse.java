package br.com.zaffari.sinapses.domain;

import java.time.LocalDate;

public record RequestSinapse(Long id, Integer matricula, String titulo, String descricao, String categoria, LocalDate dataCriacao, LocalDate dataAtualizacao,String link, String keyword, Boolean ativo) {}