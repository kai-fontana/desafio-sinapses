package br.com.zaffari.sinapses.repository;

import br.com.zaffari.sinapses.model.Sinapse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SinapseRepository extends JpaRepository<Sinapse, Integer> {
    List<Sinapse> findSinapseById(Integer Id);
}