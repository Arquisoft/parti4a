package com.asw.participationSystem.repository;

import com.asw.participationSystem.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Categoria, Long>{

	Categoria findByNombre(String name);
}
