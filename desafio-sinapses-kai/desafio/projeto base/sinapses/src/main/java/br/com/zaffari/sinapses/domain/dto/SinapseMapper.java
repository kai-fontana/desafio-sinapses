package br.com.zaffari.sinapses.domain.dto;

import org.mapstruct.Mapper;

import br.com.zaffari.sinapses.domain.entity.SinapseEntity;

@Mapper(componentModel = "spring")
public interface SinapseMapper {
    SinapseResponseDTO mapSinapseEntityToSinapseResponse(SinapseEntity sinapseEntity);
}