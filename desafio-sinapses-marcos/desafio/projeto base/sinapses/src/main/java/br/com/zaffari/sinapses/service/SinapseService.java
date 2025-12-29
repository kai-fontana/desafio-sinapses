package br.com.zaffari.sinapses.service;

import java.time.LocalDate;
import java.util.List;

import br.com.zaffari.sinapses.model.Sinapse;

public interface SinapseService {
    List<Sinapse> listarSinapsesPorMatricula(String matricula);
    List<Sinapse> listarPorCategoria(String categoria);
    List<Sinapse> listarPorData(LocalDate data);
    List<Sinapse> listarPorPalavraChave(String palavraChave);
    Sinapse pegarPorIdPermitido(Long id, String matricula);
    Sinapse salvarSinapse(Sinapse sinapse);
    void deletarSinapse(Sinapse sinapse);
}

