package com.asw.participationSystem.services;

import java.util.List;

import com.asw.participationSystem.domain.Categoria;
import com.asw.participationSystem.domain.Configuration;
import com.asw.participationSystem.domain.Sugerencia;



public interface SystemServices extends SuperService{

	Configuration getConfiguration();
	List<Categoria> getAllCategories();
	boolean contienePalabrasNoAdmitidas(String mensaje);
	boolean existeLaCategoria(Categoria cat);
	boolean existeLaSugerencia(Sugerencia sugerencia);
}
