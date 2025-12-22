package br.com.zaffari.sinapses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zaffari.sinapses.model.Sinapse;
import br.com.zaffari.sinapses.repositories.SinapseRepository;
import br.com.zaffari.sinapses.service.impl.SinapseImpl;

@RestController
@RequestMapping("/sinapses")
public class SinapseController {

    @Autowired
    protected SinapseRepository sinapseRepository;

    @Autowired
    protected SinapseImpl sinapseImpl;

    @PostMapping("/create")
    public List<Sinapse> createSinapse(@RequestBody Sinapse sinapse) {
        return sinapseImpl.create(sinapse);
    }

    @GetMapping("/list")
    public List<Sinapse> listSinapse() {
        return sinapseImpl.list();
    }

    @PutMapping("/update")
    public List<Sinapse> updateSinapse(@RequestBody Sinapse sinapse) {
        return sinapseImpl.update(sinapse);
    }

    @DeleteMapping("/delete/{id}")
    public List<Sinapse> deleteSinapse(@PathVariable("id") Sinapse id) {
        return sinapseImpl.delete(id);
    }
}