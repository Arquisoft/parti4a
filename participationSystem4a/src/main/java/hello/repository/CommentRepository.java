package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.domain.Comentario;

@Repository("commentRepository")
public interface CommentRepository extends JpaRepository<Comentario, Long>{

}
