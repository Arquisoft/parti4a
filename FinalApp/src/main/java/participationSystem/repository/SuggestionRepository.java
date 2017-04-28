package participationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import participationSystem.domain.Categoria;
import participationSystem.domain.Sugerencia;

import java.util.List;


@Repository("sugestionRepository")
public interface SuggestionRepository extends JpaRepository<Sugerencia, Long>{

    List<Sugerencia> findByCategoria(Categoria categoria);


}
