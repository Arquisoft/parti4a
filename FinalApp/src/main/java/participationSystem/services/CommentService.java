package participationSystem.services;


import participationSystem.util.exception.CitizenException;
import repository.domain.Citizen;
import repository.domain.Comentario;
import repository.domain.Sugerencia;

public interface CommentService extends SuperService{

    void createComentario(Comentario comment) throws CitizenException;

    void createComentario(String comentario, Sugerencia sugerencia, Citizen citizen);
	}
