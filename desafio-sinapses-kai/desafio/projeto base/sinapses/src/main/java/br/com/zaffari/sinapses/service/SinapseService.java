package br.com.zaffari.sinapses.service;

import br.com.zaffari.sinapses.domain.dto.SinapseRequestDTO;
import br.com.zaffari.sinapses.domain.dto.SinapseResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;


public interface SinapseService {
    Page<SinapseResponseDTO> listarTodasAtivas(String categoria, String keyword, Pageable pageable);

    SinapseResponseDTO listarPorIdTodasAtivas(Long id);
    SinapseResponseDTO salvar(SinapseRequestDTO request);
    SinapseResponseDTO atualizar(Long id, SinapseRequestDTO request);
    void excluir(Long id);
}
