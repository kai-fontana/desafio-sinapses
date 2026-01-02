package br.com.zaffari.sinapses.service;

//import java.util.List;

//import br.com.zaffari.sinapses.domain.RequestSinapse;

import br.com.zaffari.sinapses.domain.dto.SinapseResponseDTO;

public interface SinapseService {
    public SinapseResponseDTO listSinapseById(Long id);

    /*public SinapseEntity create(SinapseRequestDTO sinapseDTO);

    public List<SinapseEntity> listAll();

    public SinapseEntity listOne(Long id);

    public SinapseEntity update(Long id);

    public SinapseEntity delete(Long id);*/
}