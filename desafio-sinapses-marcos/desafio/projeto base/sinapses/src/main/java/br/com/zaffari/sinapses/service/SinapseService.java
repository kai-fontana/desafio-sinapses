package br.com.zaffari.sinapses.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.zaffari.sinapses.model.Sinapse;

public interface SinapseService {
    List<Sinapse> listarSinapsesPorMatricula(String matricula, Pageable pageable);
    List<Sinapse> listarPorCategoria(String categoria, Pageable pageable);
    List<Sinapse> listarPorData(LocalDate data, Pageable pageable);
    List<Sinapse> listarPorPalavraChave(String palavraChave, Pageable pageable);
    List<Sinapse> filtrarPorMatrícula(String matricula, List<Sinapse> listaFiltrada);
    Sinapse pegarPorIdPermitido(Long id, String matricula); 
    Sinapse salvarSinapse(Sinapse sinapse);
    void deletarSinapse(Sinapse sinapse);
}
