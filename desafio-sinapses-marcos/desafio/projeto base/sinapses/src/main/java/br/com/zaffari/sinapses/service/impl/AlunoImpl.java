package br.com.zaffari.sinapses.service.impl;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.zaffari.sinapses.model.Aluno;
import br.com.zaffari.sinapses.repository.AlunoRepository;
import br.com.zaffari.sinapses.service.AlunoService;

@Service
public class AlunoImpl implements AlunoService {
    AlunoRepository alunoRepository;

    public AlunoImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno salvarAluno(Aluno aluno){
        String ano = String.valueOf(LocalDate.now().getYear());
        long proximoNumero = alunoRepository.count() + 1;
        String geracaoMatricula = ano + "-" + String.format("%04d", proximoNumero);
        aluno.setMatricula(geracaoMatricula);
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno pegarPorMatricula(String matricula){
        return alunoRepository.findByMatricula(matricula)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula não cadastrada no sistema"));
    }

}
