package br.com.zaffari.sinapses.service.impl;

import org.springframework.stereotype.Service;

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
        return alunoRepository.save(aluno);
    }

}
