package br.com.zaffari.sinapses.controller;

import java.util.List;

import javax.smartcardio.ResponseAPDU;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zaffari.sinapses.dtos.SinapseDto;
import br.com.zaffari.sinapses.model.Sinapse;
import br.com.zaffari.sinapses.service.SinapseService;

@RestController
@RequestMapping("/sinapses")
public class SinapseController {
    SinapseService sinapseService;

    public SinapseController(SinapseService sinapseService) {
        this.sinapseService = sinapseService;
    }


    @GetMapping
    public ResponseEntity<List<Sinapse>> listarSinapses(){
        List<Sinapse> listaSinapses = sinapseService.listarSinapses();
        if (listaSinapses.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.ok(listaSinapses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sinapse> acharSinapse(@PathVariable(value = "id") Long id){
        Sinapse sinapse = sinapseService.pegarPorId(id);
        return ResponseEntity.ok(sinapse);
    }

    @PostMapping
    public ResponseEntity<Sinapse> criarSinapse(@RequestBody SinapseDto sinapseDto){
        Sinapse sinapse = new Sinapse();
        BeanUtils.copyProperties(sinapseDto, sinapse);
        Sinapse sinapseSalva = sinapseService.salvarSinapse(sinapse);
        return ResponseEntity.status(201).body(sinapseSalva);
    }

}
