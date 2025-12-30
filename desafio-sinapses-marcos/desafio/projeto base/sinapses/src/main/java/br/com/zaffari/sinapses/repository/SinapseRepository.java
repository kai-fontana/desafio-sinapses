package br.com.zaffari.sinapses.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zaffari.sinapses.model.Sinapse;

@Repository
public interface SinapseRepository extends JpaRepository<Sinapse, Long>{
    List<Sinapse> findByCategoriaIgnoreCaseOrderByDataCriacaoAsc(String categoria);
    List<Sinapse> findByDataCriacaoOrderByDataCriacaoAsc(LocalDate data);
    List<Sinapse> findByDescricaoContainingIgnoreCase(String palavraChave);
    List<Sinapse> findByAlunoMatricula(String matricula);
}

