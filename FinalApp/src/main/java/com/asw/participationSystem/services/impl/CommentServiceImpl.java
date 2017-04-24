package com.asw.participationSystem.services.impl;

import com.asw.participationSystem.domain.Citizen;
import com.asw.participationSystem.domain.Sugerencia;
import org.springframework.beans.factory.annotation.Autowired;
import com.asw.participationSystem.domain.Comentario;
import com.asw.participationSystem.producers.Topics;
import com.asw.participationSystem.repository.CommentRepository;
import com.asw.participationSystem.services.CommentService;
import com.asw.participationSystem.util.exception.CitizenException;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	private CommentRepository commentRepository;

	@Autowired
	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public void createComentario(Comentario comment) throws CitizenException {
		try {

			// addComentario(comentario);
			this.commentRepository.save(comment);
			logger.send(Topics.COMMENT_SUGGESTION,
					comment.getSugerencia().getId() + separator + comment.getContenido());
			loggerCutre.log(this.getClass(), "Comentario ID = " + comment.getId());
		} catch (Exception e) {
			throw new CitizenException("Error al crear un comentario.");
		}

	}
	
	@Override
	public void createComentario(String contenido, Sugerencia sugerencia, Citizen citizen) {
		Comentario c = new Comentario(contenido,sugerencia,citizen);
		sugerencia.addComentario(c);
		commentRepository.save(c);
	}


}
