package br.com.zaffari.sinapses.service;

import java.time.LocalDate;
import java.util.List;

import br.com.zaffari.sinapses.model.Sinapse;

public interface SinapseService {
    List<Sinapse> listarSinapses();
    List<Sinapse> listarPorCategoria(String categoria);
    List<Sinapse> listarPorData(LocalDate data);
    List<Sinapse> listarPorPalavraChave(String palavraChave);
    Sinapse pegarPorId(Long id);
    Sinapse salvarSinapse(Sinapse sinapse);
    void deletarSinapse(Sinapse sinapse);
}
