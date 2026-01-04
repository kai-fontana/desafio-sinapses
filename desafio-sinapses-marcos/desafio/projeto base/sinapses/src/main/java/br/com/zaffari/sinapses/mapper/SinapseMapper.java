package br.com.zaffari.sinapses.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.zaffari.sinapses.dtos.SinapseRequest;
import br.com.zaffari.sinapses.dtos.SinapseResponse;
import br.com.zaffari.sinapses.model.Sinapse;

@Mapper(componentModel = "spring")
public interface SinapseMapper {
    @Mapping(source = "aluno.matricula", target = "matricula")
    SinapseResponse paraResponse(Sinapse sinapse);

    Sinapse paraEntidade(SinapseRequest sinapseRequest);
}
