package es.uniovi.asw.services;

import java.util.List;

import es.uniovi.asw.domain.Categoria;
import es.uniovi.asw.domain.Citizen;
import es.uniovi.asw.util.exception.CitizenException;

public interface CitizenService extends SuperService {

	public Citizen getCitizen(String email);
	public List<Categoria> getCategoriasDisponibles() throws CitizenException;
	
}
