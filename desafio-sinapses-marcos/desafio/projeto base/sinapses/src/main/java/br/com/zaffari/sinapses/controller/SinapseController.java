package br.com.zaffari.sinapses.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zaffari.sinapses.dtos.SinapseDto;
import br.com.zaffari.sinapses.model.Sinapse;
import br.com.zaffari.sinapses.service.AlunoService;
import br.com.zaffari.sinapses.service.SinapseService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos/{matricula}/sinapses")
public class SinapseController {
    SinapseService sinapseService;
    AlunoService alunoService;

    public SinapseController(SinapseService sinapseService, AlunoService alunoService) {
        this.sinapseService = sinapseService;
        this.alunoService = alunoService;
    }


    @GetMapping
    public ResponseEntity<List<Sinapse>> listarSinapses(@PathVariable("matricula") String matricula,
    @RequestParam(value = "categoria", required = false) String categoria, 
    @RequestParam(value = "data", required = false) LocalDate data,
    @RequestParam(value = "palavraChave", required = false) String palavraChave){
        List<Sinapse> listaSinapses;
        //Queryteria
        if (categoria != null) {
            listaSinapses = sinapseService.listarPorCategoria(categoria);
        } else if (data != null) {
            listaSinapses = sinapseService.listarPorData(data);
        } else if (palavraChave != null){
            listaSinapses = sinapseService.listarPorPalavraChave(palavraChave);
        } else {
           listaSinapses = sinapseService.listarSinapsesPorMatricula(matricula);
        }
        if (listaSinapses.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.ok(listaSinapses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sinapse> acharSinapse(@PathVariable("matricula") String matricula, @PathVariable("id") Long id){
        Sinapse sinapse = sinapseService.pegarPorIdPermitido(id, matricula);

        return ResponseEntity.ok(sinapse);
    }

    @PostMapping()
    public ResponseEntity<Sinapse> criarSinapse (@PathVariable("matricula") String matricula, 
    @Valid @RequestBody SinapseDto sinapseDto){
        Sinapse sinapse = new Sinapse();
        BeanUtils.copyProperties(sinapseDto, sinapse);
        sinapse.setData(LocalDate.now());
        sinapse.setAluno(alunoService.pegarPorMatricula(matricula));
        if (sinapse.getAluno() == null) {
            return ResponseEntity.notFound().build();
    }
        Sinapse sinapseSalva = sinapseService.salvarSinapse(sinapse);
        //retornar o dto após salvo

        return ResponseEntity.status(201).body(sinapseSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sinapse> editarSinapse(@PathVariable("matricula") String matricula, @PathVariable(value = "id") Long id, 
    @Valid @RequestBody SinapseDto sinapseDto){
        Sinapse sinapse = sinapseService.pegarPorIdPermitido(id, matricula);

        BeanUtils.copyProperties(sinapseDto, sinapse);
        sinapse.setId(id);
        sinapse.setData(LocalDate.now());
        Sinapse sinapseAtualida = sinapseService.salvarSinapse(sinapse);
        return ResponseEntity.ok().body(sinapseAtualida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarSinapse(@PathVariable("matricula") String matricula, @PathVariable(value = "id") Long id){
        Sinapse sinapse = sinapseService.pegarPorIdPermitido(id, matricula);

        sinapseService.deletarSinapse(sinapse);
        return ResponseEntity.status(204).build();
    }
}

