package com.asw.participationSystem.services;

import com.asw.participationSystem.domain.Categoria;
import com.asw.participationSystem.domain.Citizen;
import com.asw.participationSystem.util.exception.CitizenException;

import java.util.List;

public interface CitizenService extends SuperService {

	public Citizen getCitizen(String email);
	public List<Categoria> getCategoriasDisponibles() throws CitizenException;
	
}
