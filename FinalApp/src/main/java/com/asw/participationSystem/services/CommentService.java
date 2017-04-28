package com.asw.participationSystem.services;

import com.asw.participationSystem.domain.Citizen;
import com.asw.participationSystem.domain.Comentario;
import com.asw.participationSystem.domain.Sugerencia;
import com.asw.participationSystem.util.exception.CitizenException;

public interface CommentService extends SuperService{

    void createComentario(Comentario comment) throws CitizenException;

    void createComentario(String comentario, Sugerencia sugerencia, Citizen citizen);
	}
