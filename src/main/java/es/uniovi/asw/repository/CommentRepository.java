package es.uniovi.asw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.domain.Comentario;

@Repository("commentRepository")
public interface CommentRepository extends JpaRepository<Comentario, Long>{

}
