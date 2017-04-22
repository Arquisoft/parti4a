package hello.services;

import hello.domain.Categoria;
import hello.domain.Citizen;
import hello.util.exception.CitizenException;

import java.util.List;

public interface CitizenService extends SuperService {

	public Citizen getCitizen(String email);
	public List<Categoria> getCategoriasDisponibles() throws CitizenException;
	
}
