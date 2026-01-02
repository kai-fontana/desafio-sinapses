

package br.com.zaffari.sinapses.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zaffari.sinapses.dtos.RequestAluno;
import br.com.zaffari.sinapses.dtos.ResponseAluno;
import br.com.zaffari.sinapses.model.Aluno;
import br.com.zaffari.sinapses.service.impl.AlunoImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    AlunoImpl alunoImpl;

    public AlunoController(AlunoImpl alunoImpl) {
        this.alunoImpl = alunoImpl;
    }



    @PostMapping
    public ResponseEntity<ResponseAluno> criarAluno(@Valid @RequestBody RequestAluno alunoDto){
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDto, aluno);
        Aluno alunoSalvo = alunoImpl.salvarAluno(aluno);
        ResponseAluno responseAluno = new ResponseAluno(alunoSalvo.getNome(), alunoSalvo.getMatricula());
        return ResponseEntity.status(201).body(responseAluno);
    }
}
