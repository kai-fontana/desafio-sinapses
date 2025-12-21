package br.com.zaffari.sinapses.service.impl;

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
    public Sinapse pegarPorId(Long id){
        return sinapseRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Id " + id + " não encontrado."));
}

    @Override
    public Sinapse salvarSinapse(Sinapse sinapse) {
        return sinapseRepository.save(sinapse);
    }

    @Override
    public void deletarSinapse(Long id){
        sinapseRepository.deleteById(id);
    }
    

}
