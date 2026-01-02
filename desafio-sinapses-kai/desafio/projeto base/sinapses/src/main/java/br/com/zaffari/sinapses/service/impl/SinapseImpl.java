package br.com.zaffari.sinapses.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.zaffari.sinapses.domain.entity.SinapseEntity;
import br.com.zaffari.sinapses.domain.dto.SinapseMapper;
import br.com.zaffari.sinapses.domain.dto.SinapseResponseDTO;
import br.com.zaffari.sinapses.repository.SinapseRepository;
import br.com.zaffari.sinapses.service.SinapseService;

import java.util.List;

@Service
public class SinapseImpl implements SinapseService{

    @Autowired
    private SinapseRepository sinapseRepository;

    private SinapseMapper sinapseMapper = Mappers.getMapper(SinapseMapper.class);
    @Override 
    public SinapseResponseDTO listSinapseById(Long id) {
        SinapseEntity sinapseEntity = sinapseRepository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new RuntimeException("Sinapse não encontrada."));
        
        SinapseResponseDTO sinapseResponseDTO =  
        return;
    }

    /*

    public SinapseImpl(SinapseRepository sinapseRepository) {
        this.sinapseRepository = sinapseRepository;
    }

 
    @Override
    public SinapseEntity create(SinapseRequestDTO sinapseDTO) {
        return sinapseRepository.save(sinapseDTO);
    }

    @Override
    public List<SinapseEntity> listAll() {
        Sort sort = Sort.by("categoria").ascending().and(
            Sort.by("dataDeEstudo").descending().and(
                Sort.by("palavrasChave").ascending()
            )
        );
        return sinapseRepository.findAll(sort);

        return sinapseRepository.findAllByAtivoTrue();
    }

    @Override
    public SinapseEntity listOne(Long id) {
        return sinapseRepository.findByIdAndAtivoTrue(id);
    }

    @Override 
    public SinapseEntity update(SinapseRequestDTO sinapseDTO, Long id, LocalDate dataAtual) {
        Optional<SinapseEntity> optionalSinapse = sinapseRepository.findByIdAndAtivoTrue(id);
        SinapseEntity sinapse = optionalSinapse.get();
        sinapseDTO.setDataAtualizacao(dataAtual.now());
        sinapseRepository.save(sinapse);
        return list();
    }

    @Override 
    public SinapseEntity delete(Long id) {
        sinapseRepository.delete(id);
        return list();
    }*/
}