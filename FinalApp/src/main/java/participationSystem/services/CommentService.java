package participationSystem.services;

import participationSystem.domain.Citizen;
import participationSystem.domain.Comentario;
import participationSystem.domain.Sugerencia;
import participationSystem.util.exception.CitizenException;

public interface CommentService extends SuperService{

    void createComentario(Comentario comment) throws CitizenException;

    void createComentario(String comentario, Sugerencia sugerencia, Citizen citizen);
	}
