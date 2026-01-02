package br.com.zaffari.sinapses.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zaffari.sinapses.model.Sinapse;

@Repository
public interface SinapseRepository extends JpaRepository<Sinapse, Long>{
    List<Sinapse> findByCategoriaIgnoreCase(String categoria, Pageable pageable);
    List<Sinapse> findByDataCriacaoOrderByDataCriacaoAsc(LocalDate data, Pageable pageable);
    List<Sinapse> findByDescricaoContainingIgnoreCase(String palavraChave, Pageable pageable);
    List<Sinapse> findByAlunoMatricula(String matricula, Pageable pageable);
}
