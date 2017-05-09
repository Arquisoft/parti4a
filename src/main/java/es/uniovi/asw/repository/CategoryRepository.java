package es.uniovi.asw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.domain.Categoria;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Categoria, Long>{

	Categoria findByNombre(String name);
}
