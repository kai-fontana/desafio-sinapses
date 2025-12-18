package br.com.zaffari.sinapses.service;

import java.util.List;

import br.com.zaffari.sinapses.model.Sinapse;

public interface SinapseService {
    List<Sinapse> mostrarSinapses();
    void criarSinapse(Sinapse sinapse);
    void deletarSinapse(int id);
}
