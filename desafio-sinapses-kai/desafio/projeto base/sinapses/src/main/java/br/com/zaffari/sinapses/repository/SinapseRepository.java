package br.com.zaffari.sinapses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zaffari.sinapses.domain.dto.SinapseRequestDTO;
import br.com.zaffari.sinapses.domain.entity.SinapseEntity;

import java.util.List;

@Repository
public interface SinapseRepository extends JpaRepository<SinapseEntity, Long> {
    List<SinapseEntity> findAllByAtivoTrue();
    SinapseEntity findByIdAndAtivoTrue(Long id);
    SinapseEntity save(SinapseRequestDTO sinapseDTO);
}