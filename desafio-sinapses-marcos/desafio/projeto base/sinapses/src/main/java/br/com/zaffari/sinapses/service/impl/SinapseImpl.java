package br.com.zaffari.sinapses.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public List<Sinapse> listarSinapsesPorMatricula(String matricula, Pageable pageable) {
        return sinapseRepository.findByAlunoMatricula(matricula, pageable);
    }

    @Override
    public List<Sinapse> listarPorCategoria(String categoria, Pageable pageable){
        return sinapseRepository.findByCategoriaIgnoreCase(categoria, pageable);
    }

    @Override
    public List<Sinapse> listarPorData(LocalDate data, Pageable pageable){
        return sinapseRepository.findByDataCriacaoOrderByDataCriacaoAsc(data, pageable);
    }

    @Override
    public List<Sinapse> listarPorPalavraChave(String palavraChave, Pageable pageable){
        return sinapseRepository.findByDescricaoContainingIgnoreCase(palavraChave, pageable);
    }

    @Override
    public List<Sinapse> filtrarPorMatrícula(String matricula, List<Sinapse> lista){
        List<Sinapse> listaFiltrada = new ArrayList<>();
        for(Sinapse sinapse : lista){
            if (sinapse.getAluno().getMatricula().equals(matricula)) {
                listaFiltrada.add(sinapse);
            }
        }
        return listaFiltrada;
    }

    @Override
    public Sinapse pegarPorIdPermitido(Long id, String matricula){
        Sinapse sinapse = sinapseRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de sinapse não existente"));

        if (!sinapse.getAluno().getMatricula().equals(matricula)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Sinapse vinculada a outra matrícula");
        }
        
        
        return sinapse;
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
