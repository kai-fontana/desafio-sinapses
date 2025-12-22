package br.com.zaffari.sinapses.service;

import java.util.List;

import br.com.zaffari.sinapses.model.Sinapse;

public interface SinapseService {
    List<Sinapse> listarSinapses();
    List<Sinapse> listarPorCategoria(String categoria);
    Sinapse pegarPorId(Long id);
    Sinapse salvarSinapse(Sinapse sinapse);
    void deletarSinapse(Sinapse sinapse);
}
