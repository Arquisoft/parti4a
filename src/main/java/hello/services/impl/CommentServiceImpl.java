package hello.services.impl;

import hello.domain.Citizen;
import hello.domain.Sugerencia;

import org.springframework.beans.factory.annotation.Autowired;

import hello.domain.Comentario;
import hello.producers.KafkaProducer;
import hello.producers.Topics;
import hello.repository.CommentRepository;
import hello.services.CommentService;
import hello.util.exception.CitizenException;

import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	private CommentRepository commentRepository;
	private KafkaProducer kafkaProducer = new KafkaProducer();

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
		Comentario c = new Comentario(contenido, sugerencia, citizen);
		sugerencia.addComentario(c);
		commentRepository.save(c);
		kafkaProducer.send("nuevoComentario",
				"Se ha añadido el comentario: '" + contenido + "' en la sugerencia: '" + sugerencia.getNombre() + "'");
	}

}
