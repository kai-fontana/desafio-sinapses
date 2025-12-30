

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
import br.com.zaffari.sinapses.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }



    @PostMapping
    public ResponseEntity<ResponseAluno> criarAluno(@Valid @RequestBody RequestAluno alunoDto){
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDto, aluno);
        Aluno alunoSalvo = alunoService.salvarAluno(aluno);
        ResponseAluno responseAluno = new ResponseAluno(alunoSalvo.getNome(), alunoSalvo.getMatricula());
        return ResponseEntity.status(201).body(responseAluno);
    }
}

