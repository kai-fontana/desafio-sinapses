package br.com.zaffari.sinapses.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record SinapseRequestDTO(Integer matricula,
                                @NotBlank(message = "O título é obrigatório")
                                String titulo, String descricao, String categoria, String link) {}