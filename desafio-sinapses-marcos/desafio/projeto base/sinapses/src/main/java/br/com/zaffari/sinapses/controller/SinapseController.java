package br.com.zaffari.sinapses.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

import br.com.zaffari.sinapses.dtos.RequestSinapse;
import br.com.zaffari.sinapses.dtos.ResponseSinapse;
import br.com.zaffari.sinapses.model.Sinapse;
import br.com.zaffari.sinapses.service.impl.AlunoImpl;
import br.com.zaffari.sinapses.service.impl.SinapseImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/{matricula}/sinapses")
public class SinapseController {
    SinapseImpl sinapseImpl;
    AlunoImpl alunoImpl;

    public SinapseController(SinapseImpl serviceImpl, AlunoImpl alunoImpl) {
        this.sinapseImpl = serviceImpl;
        this.alunoImpl = alunoImpl;
    }


    @GetMapping
    public ResponseEntity<List<Sinapse>> listarSinapses(@PathVariable("matricula") String matricula, 
    @PageableDefault(page = 0, size = 10, sort = "id")Pageable pageable,
    @RequestParam(value = "categoria", required = false) String categoria, 
    @RequestParam(value = "dataCriacao", required = false) LocalDate dataCriacao,
    @RequestParam(value = "palavraChave", required = false) String palavraChave){
        List<Sinapse> listaSinapses;
        //Criteria
        if (categoria != null) {
            List<Sinapse> lista = sinapseImpl.listarPorCategoria(categoria, pageable);
            listaSinapses = sinapseImpl.filtrarPorMatrícula(matricula, lista);
            
        } else if (dataCriacao != null) {
            List<Sinapse> lista = sinapseImpl.listarPorData(dataCriacao, pageable);
            listaSinapses = sinapseImpl.filtrarPorMatrícula(matricula, lista);
        } else if (palavraChave != null){
            List<Sinapse> lista = sinapseImpl.listarPorPalavraChave(palavraChave, pageable);
            listaSinapses = sinapseImpl.filtrarPorMatrícula(matricula, lista);
        } else {
           listaSinapses = sinapseImpl.listarSinapsesPorMatricula(matricula, pageable);
        }
        if (listaSinapses.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.ok(listaSinapses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sinapse> acharSinapse(@PathVariable("matricula") String matricula, @PathVariable("id") Long id){
        Sinapse sinapse = sinapseImpl.pegarPorIdPermitido(id, matricula);

        return ResponseEntity.ok(sinapse);
    }

    @PostMapping()
    public ResponseEntity<ResponseSinapse> criarSinapse (@PathVariable("matricula") String matricula, 
    @Valid @RequestBody RequestSinapse requestSinapse){
        Sinapse sinapse = new Sinapse();
        BeanUtils.copyProperties(requestSinapse, sinapse);
        sinapse.setDataCriacao(LocalDate.now());
        sinapse.setUltimaAtualizacao(LocalDate.now());
        sinapse.setAluno(alunoImpl.pegarPorMatricula(matricula));
        
        Sinapse sinapseSalva = sinapseImpl.salvarSinapse(sinapse);
        ResponseSinapse responseSinapse = new ResponseSinapse(sinapseSalva.getId(), sinapseSalva.getAluno().getMatricula(),
            sinapseSalva.getTitulo(), sinapseSalva.getDescricao(), sinapseSalva.getCategoria(), sinapseSalva.getDataCriacao(),
            sinapseSalva.getUltimaAtualizacao(), sinapseSalva.getUrlConteudo());

        return ResponseEntity.status(201).body(responseSinapse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSinapse> editarSinapse(@PathVariable("matricula") String matricula, @PathVariable(value = "id") Long id, 
    @Valid @RequestBody RequestSinapse requestSinapse){
        Sinapse sinapse = sinapseImpl.pegarPorIdPermitido(id, matricula);

        BeanUtils.copyProperties(requestSinapse, sinapse);
        sinapse.setId(id);
        sinapse.setUltimaAtualizacao(LocalDate.now());
        Sinapse sinapseAtualizada = sinapseImpl.salvarSinapse(sinapse);
        ResponseSinapse responseSinapse = new ResponseSinapse(sinapseAtualizada.getId(), sinapseAtualizada.getAluno().getMatricula(),
            sinapseAtualizada.getTitulo(), sinapseAtualizada.getDescricao(), sinapseAtualizada.getCategoria(), sinapseAtualizada.getDataCriacao(),
            sinapseAtualizada.getUltimaAtualizacao(), sinapseAtualizada.getUrlConteudo());

        return ResponseEntity.ok().body(responseSinapse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarSinapse(@PathVariable("matricula") String matricula, @PathVariable(value = "id") Long id){
        Sinapse sinapse = sinapseImpl.pegarPorIdPermitido(id, matricula);

        sinapseImpl.deletarSinapse(sinapse);
        return ResponseEntity.status(204).build();
    }
}