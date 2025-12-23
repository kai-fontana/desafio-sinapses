package br.com.zaffari.sinapses.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.zaffari.sinapses.model.Sinapse;
import br.com.zaffari.sinapses.repository.SinapseRepository;
import br.com.zaffari.sinapses.service.SinapseService;

@Service
public class SinapseImpl implements SinapseService {
    SinapseRepository sinapseRepository;

    public SinapseImpl(SinapseRepository sinapseRepository) {
        this.sinapseRepository = sinapseRepository;
    }

    @Override
    public List<Sinapse> listarSinapses() {
        Sort sort = Sort.by("data").ascending();
        return sinapseRepository.findAll(sort);
    }

    @Override
    public List<Sinapse> listarPorCategoria(String categoria){
        return sinapseRepository.findByCategoriaIgnoreCaseOrderByDataAsc(categoria);
    }

    @Override
    public List<Sinapse> listarPorData(LocalDate data){
        return sinapseRepository.findByDataOrderByDataAsc(data);
    }

    @Override
    public List<Sinapse> listarPorPalavraChave(String palavraChave){
        return sinapseRepository.findByDescricaoContainingIgnoreCase(palavraChave);
    }

    @Override
    public Sinapse pegarPorId(Long id){
        return sinapseRepository.findById(id)
        .orElse(null);
    }

    @Override
    public Sinapse salvarSinapse(Sinapse sinapse) {
        return sinapseRepository.save(sinapse);
    }

    @Override
    public void deletarSinapse(Sinapse sinapse){
        sinapseRepository.delete(sinapse);
    }
    

}

