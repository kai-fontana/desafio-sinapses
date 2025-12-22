package br.com.zaffari.sinapses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zaffari.sinapses.model.Sinapse;
import br.com.zaffari.sinapses.repositories.SinapseRepository;

@RestController
@RequestMapping("/sinapses")
public class SinapseController {

    @Autowired
    protected SinapseRepository sinapseRepository;

    @PostMapping("/criar")
    public String postSinapse() {
        
        return "";
    }

    @GetMapping
    public List<Sinapse> getSinapse() {
        return sinapseRepository.findAll();
    }

    @PostMapping("/salvar")
    public String saveSinapses(@RequestBody Sinapse sinapse) {
        sinapseRepository.save(sinapse);
        return "";
    }

}