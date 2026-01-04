package br.com.zaffari.sinapses.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SinapseResponseDTO(Long id, String titulo, String descricao, String categoria, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, String link, String keyword) {}