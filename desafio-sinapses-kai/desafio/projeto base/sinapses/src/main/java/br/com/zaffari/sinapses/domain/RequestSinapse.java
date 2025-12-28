package br.com.zaffari.sinapses.domain;

import java.time.LocalDate;

public record RequestSinapse(Long id, Integer registration, String title, String description, String category, LocalDate date, String link, String keyword) {

}