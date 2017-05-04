package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import repository.domain.Categoria;
import repository.domain.Sugerencia;


@Repository("suggestionRepository")
public interface SuggestionRepository extends JpaRepository<Sugerencia, Long>{

    List<Sugerencia> findByCategoria(Categoria categoria);


}
