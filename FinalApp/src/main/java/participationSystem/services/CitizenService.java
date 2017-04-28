package participationSystem.services;

import java.util.List;

import participationSystem.domain.Categoria;
import participationSystem.domain.Citizen;
import participationSystem.util.exception.CitizenException;

public interface CitizenService extends SuperService {

	public Citizen getCitizen(String email);
	public List<Categoria> getCategoriasDisponibles() throws CitizenException;
	
}
