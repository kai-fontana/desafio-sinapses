package br.com.zaffari.sinapses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zaffari.sinapses.domain.Sinapse;
import br.com.zaffari.sinapses.domain.RequestSinapse;
import br.com.zaffari.sinapses.repository.SinapseRepository;
import jakarta.transaction.Transactional;


/*
* Arrumar a matrícula
*/
@RestController
@RequestMapping("/sinapses")
public class SinapseController {

    @Autowired
    protected SinapseRepository sinapseRepository;

    @GetMapping
    public ResponseEntity getAllSinapses() {
        var allSinapses = sinapseRepository.findAll();
        System.out.println(allSinapses);
        return ResponseEntity.ok(allSinapses);
    }

    @PostMapping
    public ResponseEntity createSinapse(@RequestBody RequestSinapse data) {
        
        System.out.println(data);
        Sinapse sinapse = new Sinapse(data);
        sinapseRepository.save(sinapse);
        return ResponseEntity.ok().build();
    }


    /* PRECISO CORRIGIR ESSE ENDPOINT */
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateSinapse(@PathVariable(name = "id") @RequestBody RequestSinapse data) {
        Optional<Sinapse> optionalSinapse = sinapseRepository.findById(data.id());
        if(optionalSinapse.isPresent()) {
            Sinapse sinapse = optionalSinapse.get();
            sinapse.setTitle(data.title());
            sinapse.setDescription(data.description());
            sinapse.setCategory(data.category());
            sinapse.setDate(data.date());
            sinapse.setLink(data.link());
            sinapse.setKeyword(data.keyword());
            return ResponseEntity.ok(sinapse);
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }
}

    // PRECISO CORRIGIR ESSE ENDPOINT */
//     @DeleteMapping("/{id}")
//     public ResponseEntity deleteSinapse(@PathVariable("id") Sinapse id) {
//         //Sinapse sinapse = sinapseRepository.delete(id);
//         return ResponseEntity.ok(sinapse);
//     }

