package br.com.zaffari.sinapses.service;

import br.com.zaffari.sinapses.domain.dto.SinapseRequestDTO;
import br.com.zaffari.sinapses.domain.dto.SinapseResponseDTO;
import br.com.zaffari.sinapses.domain.entity.SinapseEntity;
import br.com.zaffari.sinapses.domain.mapper.SinapseMapper;
import br.com.zaffari.sinapses.repository.SinapseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class SinapseImpl implements SinapseService {
    @Autowired
    private SinapseRepository sinapseRepository;

    @Autowired
    private SinapseMapper sinapseMapper;

    @Override
    public Page<SinapseResponseDTO> listarTodasAtivas(String categoria, String keyword, LocalDateTime data, Pageable pageable) {
        Page<SinapseEntity> entities = sinapseRepository.findByAtivoTrueAndCategoriaContainingIgnoreCaseAndTituloContainingIgnoreCase(categoria, keyword, data, pageable);
        return entities.map(sinapseMapper::mapSinapseEntityToSinapseResponse);
    }

    //Ajeitar exception
    @Override
    public SinapseResponseDTO listarPorIdTodasAtivas(Long id) {
        SinapseEntity entity = sinapseRepository.findByIdAndAtivoTrue(id);
        if (entity == null) {
            throw new RuntimeException("Id nulo");
        }
        return sinapseMapper.mapSinapseEntityToSinapseResponse(entity);
    }

    @Override
    @Transactional
    public SinapseResponseDTO salvar(SinapseRequestDTO request) {
        SinapseEntity entity = sinapseMapper.mapSinapseRequestToSinapseEntity(request);
        entity.setDataCriacao(LocalDateTime.now());
        entity.setDataAtualizacao(LocalDateTime.now());
        entity.setAtivo(true);

        SinapseEntity entitySalva = sinapseRepository.save(entity);
        return sinapseMapper.mapSinapseEntityToSinapseResponse(entitySalva);
    }

    @Override
    @Transactional
    public SinapseResponseDTO atualizar(Long id, SinapseRequestDTO request) {
        SinapseEntity entity = sinapseRepository.findByIdAndAtivoTrue(id);

        sinapseMapper.updateSinapseFromDto(request, entity);
        entity.setDataAtualizacao(LocalDateTime.now());

        SinapseEntity entitySalva = sinapseRepository.save(entity);
        return sinapseMapper.mapSinapseEntityToSinapseResponse(entitySalva);

    }

    @Override
    @Transactional
    public void excluir(Long id) {
        SinapseEntity entity = sinapseRepository.findByIdAndAtivoTrue(id);
        entity.setAtivo(false);
    }
}
