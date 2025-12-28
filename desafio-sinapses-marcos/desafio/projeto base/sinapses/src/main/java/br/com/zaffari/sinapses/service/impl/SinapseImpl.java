package br.com.zaffari.sinapses.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public List<Sinapse> listarSinapsesPorMatricula(String matricula) {
        return sinapseRepository.findByAlunoMatricula(matricula);
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
    public Sinapse pegarPorIdPermitido(Long id, String matricula){
        Sinapse sinapse = sinapseRepository.findById(id)
        .orElse(null);

        if (sinapse == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não encontrado");
        }

        if (!sinapse.getAluno().getMatricula().equals(matricula)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Id vinculado a outra matrícula");
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
