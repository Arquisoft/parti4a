package participationSystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import participationSystem.domain.Citizen;
import participationSystem.domain.Comentario;
import participationSystem.domain.Sugerencia;
import participationSystem.producers.Topics;
import participationSystem.repository.CommentRepository;
import participationSystem.services.CommentService;
import participationSystem.util.exception.CitizenException;

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
