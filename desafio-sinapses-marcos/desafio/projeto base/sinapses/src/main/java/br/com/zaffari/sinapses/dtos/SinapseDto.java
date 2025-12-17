package main.java.br.com.zaffari.sinapses.dtos;

import java.time.LocalDate;

public record SinapseDto(String titulo, String descricao,
    String categoria, LocalDate data, String urlConteudo
) {

}
