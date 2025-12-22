package br.com.zaffari.sinapses.controller;

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
import br.com.zaffari.sinapses.service.SinapseService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sinapses")
public class SinapseController {
    SinapseService sinapseService;

    public SinapseController(SinapseService sinapseService) {
        this.sinapseService = sinapseService;
    }


    @GetMapping
    public ResponseEntity<List<Sinapse>> listarSinapses(@RequestParam(required = false) String categoria){
        List<Sinapse> listaSinapses;
        if (categoria != null) {
            listaSinapses = sinapseService.listarPorCategoria(categoria);
        } else {
           listaSinapses = sinapseService.listarSinapses();
        }
        if (listaSinapses.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.ok(listaSinapses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sinapse> acharSinapse(@PathVariable(value = "id") Long id){
        Sinapse sinapse = sinapseService.pegarPorId(id);
        if (sinapse == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(sinapse);
    }

    @PostMapping()
    public ResponseEntity<Sinapse> criarSinapse (@Valid @RequestBody SinapseDto sinapseDto){
        Sinapse sinapse = new Sinapse();
        BeanUtils.copyProperties(sinapseDto, sinapse);
        Sinapse sinapseSalva = sinapseService.salvarSinapse(sinapse);
        return ResponseEntity.status(201).body(sinapseSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sinapse> editarSinapse(@PathVariable(value = "id") Long id, 
        @Valid @RequestBody SinapseDto sinapseDto){
        Sinapse sinapse = sinapseService.pegarPorId(id);
         if (sinapse == null) {
            return ResponseEntity.status(404).build();
        }
        BeanUtils.copyProperties(sinapseDto, sinapse);
        sinapse.setId(id);
        Sinapse sinapseAtualida = sinapseService.salvarSinapse(sinapse);
        return ResponseEntity.ok().body(sinapseAtualida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarSinapse(@PathVariable(value = "id") Long id){
        Sinapse sinapse = sinapseService.pegarPorId(id);
         if (sinapse == null) {
            return ResponseEntity.status(404).build();
        }
        sinapseService.deletarSinapse(sinapse);
        return ResponseEntity.status(204).build();
    }
}

