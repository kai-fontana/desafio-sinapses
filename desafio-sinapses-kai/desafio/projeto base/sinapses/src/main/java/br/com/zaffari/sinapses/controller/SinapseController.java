package br.com.zaffari.sinapses.controller;

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
        var allSinapses = sinapseRepository.findAllByActiveTrue();
        System.out.println(allSinapses);
        return ResponseEntity.ok(allSinapses);
    }

    @PostMapping
    public ResponseEntity createSinapse(@RequestBody RequestSinapse data) {

        Sinapse sinapse = new Sinapse(data);
        if (data != null) {
            sinapseRepository.save(sinapse);
            return ResponseEntity.ok("Sinapse criada com sucesso.");
            
        } else {
            return ResponseEntity.notFound().build();
        }
    
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateSinapse(@PathVariable(value = "id") Long id, @RequestBody RequestSinapse data) {
        Optional<Sinapse> optionalSinapse = sinapseRepository.findById(id);
        if(optionalSinapse.isPresent()) {
            Sinapse sinapse = optionalSinapse.get();
            sinapse.setTitulo(data.titulo());
            sinapse.setDescricao(data.descricao());
            sinapse.setCategoria(data.categoria());
            sinapse.setMatricula(data.matricula());
            sinapse.setData(data.data());
            sinapse.setLink(data.link());
            sinapse.setKeyword(data.keyword());
            sinapseRepository.save(sinapse);
            return ResponseEntity.ok("Sinapse atualizada com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  @DeleteMapping("/{id}")
    public ResponseEntity deleteSinapse(@PathVariable("id") Long id) {
        Optional<Sinapse> optionalSinapse = sinapseRepository.findById(id);
        if(optionalSinapse.isPresent()) {
            Sinapse sinapse = optionalSinapse.get();
            sinapse.setAtivo(false);
   
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }



        /* Sinapse sinapse = sinapseRepository.findById(id)
        .orElse(null);
        sinapseRepository.delete(sinapse);
        return ResponseEntity.ok("Sinapse excluída com sucesso."); */
    }
}