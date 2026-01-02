package br.com.zaffari.sinapses.domain.dto;

import java.time.LocalDate;

public record SinapseResponseDTO(Long id, String titulo, String descricao, String categoria, LocalDate dataCriacao, LocalDate dataAtualizacao, String link, String keyword) {}