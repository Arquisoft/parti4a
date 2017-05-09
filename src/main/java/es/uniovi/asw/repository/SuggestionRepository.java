package es.uniovi.asw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.domain.Categoria;
import es.uniovi.asw.domain.Sugerencia;

import java.util.List;


@Repository("sugestionRepository")
public interface SuggestionRepository extends JpaRepository<Sugerencia, Long>{

    List<Sugerencia> findByCategoria(Categoria categoria);


}
