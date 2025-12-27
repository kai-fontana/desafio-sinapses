package br.com.zaffari.sinapses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zaffari.sinapses.domain.Sinapse;

import java.util.List;

@Repository
public interface SinapseRepository extends JpaRepository<Sinapse, Integer> {
    List<Sinapse> findSinapseById(Integer id);
}