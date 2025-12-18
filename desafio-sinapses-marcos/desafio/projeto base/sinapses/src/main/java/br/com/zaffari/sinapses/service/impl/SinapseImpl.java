package br.com.zaffari.sinapses.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zaffari.sinapses.model.Sinapse;
import br.com.zaffari.sinapses.repository.SinapseRepository;
import br.com.zaffari.sinapses.service.SinapseService;

@Service
public class SinapseImpl implements SinapseService {
    @Autowired
    SinapseRepository sinapseRepository;

    @Override
    public List<Sinapse> mostrarSinapses() {
        return sinapseRepository.findAll();
    }

    @Override
    public void criarSinapse(Sinapse sinapse) {
        sinapseRepository.save(sinapse);
    }

    @Override
    public void deletarSinapse(int id){
        sinapseRepository.deleteById(id);
    }
    

}
