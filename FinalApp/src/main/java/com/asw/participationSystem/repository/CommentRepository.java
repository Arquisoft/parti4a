package com.asw.participationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asw.participationSystem.domain.Comentario;

@Repository("commentRepository")
public interface CommentRepository extends JpaRepository<Comentario, Long>{

}
