/* br.com.zaffari.sinapses.repositories;

import br.com.zaffari.sinapses.model.Sinapse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinapsesRepository extends JpaRepository<Sinapse, Integer> {
    List<Sinapse> findSinjapseBy_id(Integer Id);
}*/