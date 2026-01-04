package br.com.zaffari.sinapses.domain.mapper;

import br.com.zaffari.sinapses.domain.dto.SinapseRequestDTO;
import br.com.zaffari.sinapses.domain.dto.SinapseResponseDTO;
import br.com.zaffari.sinapses.domain.entity.SinapseEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-04T18:26:43-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-9.2.1.jar, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class SinapseMapperImpl implements SinapseMapper {

    @Override
    public SinapseEntity mapSinapseRequestToSinapseEntity(SinapseRequestDTO sinapseRequestDTO) {
        if ( sinapseRequestDTO == null ) {
            return null;
        }

        SinapseEntity sinapseEntity = new SinapseEntity();

        sinapseEntity.setMatricula( sinapseRequestDTO.matricula() );
        sinapseEntity.setTitulo( sinapseRequestDTO.titulo() );
        sinapseEntity.setDescricao( sinapseRequestDTO.descricao() );
        sinapseEntity.setCategoria( sinapseRequestDTO.categoria() );
        sinapseEntity.setLink( sinapseRequestDTO.link() );

        return sinapseEntity;
    }

    @Override
    public SinapseResponseDTO mapSinapseEntityToSinapseResponse(SinapseEntity sinapse) {
        if ( sinapse == null ) {
            return null;
        }

        Long id = null;
        String titulo = null;
        String descricao = null;
        String categoria = null;
        LocalDateTime dataCriacao = null;
        LocalDateTime dataAtualizacao = null;
        String link = null;
        String keyword = null;

        id = sinapse.getId();
        titulo = sinapse.getTitulo();
        descricao = sinapse.getDescricao();
        categoria = sinapse.getCategoria();
        dataCriacao = sinapse.getDataCriacao();
        dataAtualizacao = sinapse.getDataAtualizacao();
        link = sinapse.getLink();
        keyword = sinapse.getKeyword();

        SinapseResponseDTO sinapseResponseDTO = new SinapseResponseDTO( id, titulo, descricao, categoria, dataCriacao, dataAtualizacao, link, keyword );

        return sinapseResponseDTO;
    }

    @Override
    public List<SinapseResponseDTO> mapSinapseEntityToSinapseResponse(List<SinapseEntity> sinapses) {
        if ( sinapses == null ) {
            return null;
        }

        List<SinapseResponseDTO> list = new ArrayList<SinapseResponseDTO>( sinapses.size() );
        for ( SinapseEntity sinapseEntity : sinapses ) {
            list.add( mapSinapseEntityToSinapseResponse( sinapseEntity ) );
        }

        return list;
    }

    @Override
    public void updateSinapseFromDto(SinapseRequestDTO dto, SinapseEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setMatricula( dto.matricula() );
        entity.setTitulo( dto.titulo() );
        entity.setDescricao( dto.descricao() );
        entity.setCategoria( dto.categoria() );
        entity.setLink( dto.link() );
    }
}
