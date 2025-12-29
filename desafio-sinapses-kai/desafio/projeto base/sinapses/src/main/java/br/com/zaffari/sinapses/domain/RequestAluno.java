package br.com.zaffari.sinapses.domain;

import java.util.List;

public record RequestAluno(Long matricula, String nome, List<Sinapse> sinapses) {}