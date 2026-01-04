package br.com.zaffari.sinapses.controller;

import br.com.zaffari.sinapses.domain.dto.SinapseRequestDTO;
import br.com.zaffari.sinapses.domain.dto.SinapseResponseDTO;
import br.com.zaffari.sinapses.domain.entity.SinapseEntity;
import br.com.zaffari.sinapses.domain.mapper.SinapseMapper;
import br.com.zaffari.sinapses.service.SinapseService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


/*
 * Arrumar a matrícula
 */
@RestController
@RequestMapping("/sinapses")
public class SinapseController {
    @Autowired
    protected SinapseService sinapseService;

    @GetMapping
    public ResponseEntity<Page<SinapseResponseDTO>> getAllSinapses(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String keyword,
            @PageableDefault(size = 10, sort = "dataCriacao", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        try {
            Page<SinapseResponseDTO> response = sinapseService.listarTodasAtivas(categoria, keyword, pageable);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<SinapseResponseDTO> getOneSinapse(@PathVariable(value = "id") Long id){

        try {
            SinapseResponseDTO response = sinapseService.listarPorIdTodasAtivas(id);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<SinapseResponseDTO> createSinapse(@Valid @RequestBody SinapseRequestDTO sinapseRequest) {

        try {
            SinapseResponseDTO response = sinapseService.salvar(sinapseRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<SinapseResponseDTO> updateSinapse(@PathVariable(value = "id") Long id, @RequestBody SinapseRequestDTO sinapseRequest) {

        try {
            SinapseResponseDTO responseAtualizada = sinapseService.atualizar(id, sinapseRequest);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<String> deleteSinapse(@PathVariable("id") Long id) {
        try {
            sinapseService.excluir(id);
            return ResponseEntity.ok("Sinapse deletada com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
  }
}