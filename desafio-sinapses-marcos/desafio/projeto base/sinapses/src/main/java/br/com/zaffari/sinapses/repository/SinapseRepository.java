package br.com.zaffari.sinapses.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zaffari.sinapses.model.Sinapse;

@Repository
public interface SinapseRepository extends JpaRepository<Sinapse, Long>{
    Page<Sinapse> findByCategoriaIgnoreCaseAndAlunoMatricula(String categoria, String matricula, Pageable pageable);
    Page<Sinapse> findByDataCriacaoAndAlunoMatricula(LocalDate data, String matricula, Pageable pageable);
    Page<Sinapse> findByDescricaoIgnoreCaseAndAlunoMatricula(String palavraChave, String matricula, Pageable pageable);
    Page<Sinapse> findByAlunoMatricula(String matricula, Pageable pageable);
}
