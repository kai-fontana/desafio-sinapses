package br.com.zaffari.sinapses.domain.mapper;

import br.com.zaffari.sinapses.domain.dto.SinapseRequestDTO;
import br.com.zaffari.sinapses.domain.dto.SinapseResponseDTO;
import org.mapstruct.Mapper;

import br.com.zaffari.sinapses.domain.entity.SinapseEntity;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SinapseMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    SinapseEntity mapSinapseRequestToSinapseEntity(SinapseRequestDTO sinapseRequestDTO);
    SinapseResponseDTO mapSinapseEntityToSinapseResponse(SinapseEntity sinapse);
    List<SinapseResponseDTO> mapSinapseEntityToSinapseResponse(List<SinapseEntity> sinapses);
    void updateSinapseFromDto(SinapseRequestDTO dto, @MappingTarget SinapseEntity entity);
}