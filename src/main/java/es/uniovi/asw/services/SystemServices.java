package es.uniovi.asw.services;

import java.util.List;

import es.uniovi.asw.domain.Categoria;
import es.uniovi.asw.domain.Configuration;
import es.uniovi.asw.domain.Sugerencia;



public interface SystemServices extends SuperService{

	Configuration getConfiguration();
	List<Categoria> getAllCategories();
	boolean contienePalabrasNoAdmitidas(String mensaje);
	boolean existeLaCategoria(Categoria cat);
	boolean existeLaSugerencia(Sugerencia sugerencia);
}
