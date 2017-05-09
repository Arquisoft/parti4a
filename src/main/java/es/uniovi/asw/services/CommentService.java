package es.uniovi.asw.services;

import es.uniovi.asw.domain.Citizen;
import es.uniovi.asw.domain.Comentario;
import es.uniovi.asw.domain.Sugerencia;
import es.uniovi.asw.util.exception.CitizenException;

public interface CommentService extends SuperService{

    void createComentario(Comentario comment) throws CitizenException;

    void createComentario(String comentario, Sugerencia sugerencia, Citizen citizen);
	}
