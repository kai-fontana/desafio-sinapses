package br.com.zaffari.sinapses.service.impl;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.zaffari.sinapses.dtos.SinapseRequest;
import br.com.zaffari.sinapses.dtos.SinapseResponse;
import br.com.zaffari.sinapses.mapper.SinapseMapper;
import br.com.zaffari.sinapses.model.Aluno;
import br.com.zaffari.sinapses.model.Sinapse;
import br.com.zaffari.sinapses.repository.AlunoRepository;
import br.com.zaffari.sinapses.repository.SinapseRepository;
import br.com.zaffari.sinapses.service.SinapseService;

@Service
public class SinapseImpl implements SinapseService {
    private final SinapseRepository sinapseRepository;
    private final SinapseMapper sinapseMapper;
    private final AlunoRepository alunoRepository;

    

    public SinapseImpl(SinapseRepository sinapseRepository, SinapseMapper sinapseMapper,
            AlunoRepository alunoRepository) {
        this.sinapseRepository = sinapseRepository;
        this.sinapseMapper = sinapseMapper;
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Page<SinapseResponse> listarSinapsesPorMatricula(String matricula, Pageable pageable) {
        Page<Sinapse> sinapsesFiltradas = sinapseRepository.findByAlunoMatricula(matricula, pageable);

        return sinapsesFiltradas.map(sinapseMapper::paraResponse);
    }

    @Override
    public Page<SinapseResponse> listarPorCategoria(String categoria, String matricula, Pageable pageable) {
        Page<Sinapse> sinapsesFiltradas = sinapseRepository.findByCategoriaIgnoreCaseAndAlunoMatricula(categoria, matricula, pageable);
    
        return sinapsesFiltradas.map(sinapseMapper::paraResponse);
}

    @Override
    public Page<SinapseResponse> listarPorData(LocalDate data, String matricula, Pageable pageable){
        Page<Sinapse> sinapsesFiltradas = sinapseRepository.findByDataCriacaoAndAlunoMatricula(data, matricula, pageable);
    
        return sinapsesFiltradas.map(sinapseMapper::paraResponse);
    }

    @Override
    public Page<SinapseResponse> listarPorPalavraChave(String palavraChave, String matricula, Pageable pageable){
        Page<Sinapse> sinapsesFiltradas = sinapseRepository.findByDescricaoIgnoreCaseAndAlunoMatricula(palavraChave, matricula, pageable);
        return sinapsesFiltradas.map(sinapseMapper::paraResponse);
    }


    @Override
    public SinapseResponse pegarPorIdPermitido(Long id, String matricula){
        Sinapse sinapse = sinapseRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de sinapse não existente"));

        if (!sinapse.getAluno().getMatricula().equals(matricula)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Sinapse vinculada a outra matrícula");
        }
        
        
        return sinapseMapper.paraResponse(sinapse);
    }

    @Override
    public SinapseResponse salvarSinapse(SinapseRequest sinapseRequest, String matricula) {
        Sinapse sinapse = sinapseMapper.paraEntidade(sinapseRequest);
        Aluno aluno = alunoRepository.findByMatricula(matricula)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado pela matrícula"));

        sinapse.setAluno(aluno);
        if (sinapse.getDataCriacao() == null) {
            sinapse.setDataCriacao(LocalDate.now());
        }
        sinapse.setUltimaAtualizacao(LocalDate.now());
        Sinapse sinapseSalva = sinapseRepository.save(sinapse);

        return sinapseMapper.paraResponse(sinapseSalva);
    }

    @Override
    public SinapseResponse atualizarSinapse(Long id, SinapseRequest sinapseRequest) {
        Sinapse sinapse = sinapseRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sinapse não encontrada."));

        sinapse.setTitulo(sinapseRequest.titulo());
        sinapse.setDescricao(sinapseRequest.descricao());
        sinapse.setCategoria(sinapseRequest.categoria());
        sinapse.setUltimaAtualizacao(LocalDate.now());

        Sinapse sinapseSalva = sinapseRepository.save(sinapse);

        return sinapseMapper.paraResponse(sinapseSalva);
}

    @Override
    public void deletarSinapse(Long id, String matricula){
        Sinapse sinapse = sinapseRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sinapse não encontrada."));

        if (!sinapse.getAluno().getMatricula().equals(matricula)) {
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Esta sinapse está vinculada a outra matrícula.");
        }
        sinapseRepository.delete(sinapse);
    }
    

}
