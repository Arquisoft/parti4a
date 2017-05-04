package participationSystem.services;

import java.util.List;

import participationSystem.util.exception.CitizenException;
import repository.domain.Categoria;
import repository.domain.Citizen;

public interface CitizenService extends SuperService {

	public Citizen getCitizen(String email);
	public List<Categoria> getCategoriasDisponibles() throws CitizenException;
	
}
