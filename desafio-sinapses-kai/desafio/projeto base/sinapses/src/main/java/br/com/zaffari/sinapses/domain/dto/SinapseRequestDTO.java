package br.com.zaffari.sinapses.domain.dto;

import java.time.LocalDate;

public record SinapseRequestDTO(Integer matricula, String titulo, String descricao, String categoria, LocalDate dataCriacao, String link, String keyword) {}