package br.com.zaffari.sinapses.mapper;

import br.com.zaffari.sinapses.dtos.SinapseRequest;
import br.com.zaffari.sinapses.dtos.SinapseResponse;
import br.com.zaffari.sinapses.model.Aluno;
import br.com.zaffari.sinapses.model.Sinapse;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-03T19:21:35-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-9.2.1.jar, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class SinapseMapperImpl implements SinapseMapper {

    @Override
    public SinapseResponse paraResponse(Sinapse sinapse) {
        if ( sinapse == null ) {
            return null;
        }

        String matricula = null;
        long id = 0L;
        String titulo = null;
        String descricao = null;
        String categoria = null;
        LocalDate dataCriacao = null;
        LocalDate ultimaAtualizacao = null;
        String urlConteudo = null;

        matricula = sinapseAlunoMatricula( sinapse );
        id = sinapse.getId();
        titulo = sinapse.getTitulo();
        descricao = sinapse.getDescricao();
        categoria = sinapse.getCategoria();
        dataCriacao = sinapse.getDataCriacao();
        ultimaAtualizacao = sinapse.getUltimaAtualizacao();
        urlConteudo = sinapse.getUrlConteudo();

        SinapseResponse sinapseResponse = new SinapseResponse( id, matricula, titulo, descricao, categoria, dataCriacao, ultimaAtualizacao, urlConteudo );

        return sinapseResponse;
    }

    @Override
    public Sinapse paraEntidade(SinapseRequest sinapseRequest) {
        if ( sinapseRequest == null ) {
            return null;
        }

        Sinapse sinapse = new Sinapse();

        sinapse.setTitulo( sinapseRequest.titulo() );
        sinapse.setDescricao( sinapseRequest.descricao() );
        sinapse.setCategoria( sinapseRequest.categoria() );
        sinapse.setUrlConteudo( sinapseRequest.urlConteudo() );

        return sinapse;
    }

    private String sinapseAlunoMatricula(Sinapse sinapse) {
        if ( sinapse == null ) {
            return null;
        }
        Aluno aluno = sinapse.getAluno();
        if ( aluno == null ) {
            return null;
        }
        String matricula = aluno.getMatricula();
        if ( matricula == null ) {
            return null;
        }
        return matricula;
    }
}
