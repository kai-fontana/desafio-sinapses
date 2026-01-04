package br.com.zaffari.sinapses.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.zaffari.sinapses.dtos.SinapseRequest;
import br.com.zaffari.sinapses.dtos.SinapseResponse;

public interface SinapseService {
    Page<SinapseResponse> listarSinapsesPorMatricula(String matricula, Pageable pageable);
    Page<SinapseResponse> listarPorCategoria(String categoria, String matricula, Pageable pageable);
    Page<SinapseResponse> listarPorData(LocalDate data, String matricula, Pageable pageable);
    Page<SinapseResponse> listarPorPalavraChave(String palavraChave, String matricula, Pageable pageable);
    SinapseResponse pegarPorIdPermitido(Long id, String matricula); 
    SinapseResponse salvarSinapse(SinapseRequest sinapseRequest, String matricula);
    SinapseResponse atualizarSinapse(Long id, SinapseRequest request);
    void deletarSinapse(Long id, String matricula);
}
