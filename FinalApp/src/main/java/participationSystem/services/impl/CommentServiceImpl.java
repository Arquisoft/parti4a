package participationSystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kafka.producers.Topics;
import participationSystem.services.CommentService;
import participationSystem.util.exception.CitizenException;
import repository.CommentRepository;
import repository.domain.Citizen;
import repository.domain.Comentario;
import repository.domain.Sugerencia;

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
