package br.com.zaffari.sinapses.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zaffari.sinapses.dtos.AlunoDto;
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
    public ResponseEntity<Aluno> criarAluno(@Valid @RequestBody AlunoDto alunoDto){
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDto, aluno);
        Aluno alunoSalvo = alunoService.salvarAluno(aluno);
        return ResponseEntity.status(201).body(alunoSalvo);
    }
}

