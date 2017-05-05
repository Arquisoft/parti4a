package hello.repository;

import hello.domain.Categoria;
import hello.domain.Sugerencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("sugestionRepository")
public interface SuggestionRepository extends JpaRepository<Sugerencia, Long>{

    List<Sugerencia> findByCategoria(Categoria categoria);


}
