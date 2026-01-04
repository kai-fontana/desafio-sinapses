package br.com.zaffari.sinapses.controller;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import br.com.zaffari.sinapses.dtos.SinapseRequest;
import br.com.zaffari.sinapses.dtos.SinapseResponse;
import br.com.zaffari.sinapses.service.impl.SinapseImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/{matricula}/sinapses")
public class SinapseController {
    private final SinapseImpl sinapseService;

    public SinapseController(SinapseImpl sinapseService) {
        this.sinapseService = sinapseService;
    }


    @GetMapping
    public ResponseEntity<Page<SinapseResponse>> listarSinapses(@PathVariable("matricula") String matricula, 
    @PageableDefault(page = 0, size = 10, sort = "id")Pageable pageable,
    @RequestParam(value = "categoria", required = false) String categoria, 
    @RequestParam(value = "data", required = false) LocalDate dataCriacao,
    @RequestParam(value = "palavraChave", required = false) String palavraChave){
        Page<SinapseResponse> listaSinapses;
        //Criteria
        if (categoria != null) {
            listaSinapses = sinapseService.listarPorCategoria(categoria, matricula, pageable);
            
            
        } else if (dataCriacao != null) {
            listaSinapses = sinapseService.listarPorData(dataCriacao, matricula, pageable);
            
        } else if (palavraChave != null){
            listaSinapses = sinapseService.listarPorPalavraChave(palavraChave, matricula, pageable);
            
        } else {
           listaSinapses = sinapseService.listarSinapsesPorMatricula(matricula, pageable);
        }
        if (listaSinapses.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.ok(listaSinapses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SinapseResponse> acharSinapse(@PathVariable("matricula") String matricula, @PathVariable("id") Long id){
        SinapseResponse sinapseResponse = sinapseService.pegarPorIdPermitido(id, matricula);

        return ResponseEntity.ok(sinapseResponse);
    }

    @PostMapping()
    public ResponseEntity<SinapseResponse> criarSinapse (@PathVariable("matricula") String matricula, 
    @Valid @RequestBody SinapseRequest sinapseRequest){
        SinapseResponse sinapseResponse = sinapseService.salvarSinapse(sinapseRequest, matricula);
    
        return ResponseEntity.status(201).body(sinapseResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SinapseResponse> editarSinapse(@PathVariable(value = "id") Long id, 
    @Valid @RequestBody SinapseRequest sinapseRequest){
        
        SinapseResponse sinapseResponse = sinapseService.atualizarSinapse(id, sinapseRequest);
        return ResponseEntity.ok().body(sinapseResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSinapse(@PathVariable("matricula") String matricula, @PathVariable(value = "id") Long id){
        sinapseService.deletarSinapse(id, matricula);
        return ResponseEntity.status(204).build();
    }
}