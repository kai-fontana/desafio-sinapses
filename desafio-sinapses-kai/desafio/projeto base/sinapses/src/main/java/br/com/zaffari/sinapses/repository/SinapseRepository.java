package br.com.zaffari.sinapses.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zaffari.sinapses.domain.entity.SinapseEntity;

import java.time.LocalDateTime;

@Repository
public interface SinapseRepository extends JpaRepository<SinapseEntity, Long> {
    Page<SinapseEntity> findByAtivoTrueAndCategoriaContainingIgnoreCaseAndTituloContainingIgnoreCase(String categoria, String keyword, LocalDateTime data, Pageable pageable);
    SinapseEntity findByIdAndAtivoTrue(Long id);
}