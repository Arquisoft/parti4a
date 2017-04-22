package hello.services;

import java.util.List;

import hello.domain.Categoria;
import hello.domain.Configuration;
import hello.domain.Sugerencia;



public interface SystemServices extends SuperService{

	Configuration getConfiguration();
	List<Categoria> getAllCategories();
	boolean contienePalabrasNoAdmitidas(String mensaje);
	boolean existeLaCategoria(Categoria cat);
	boolean existeLaSugerencia(Sugerencia sugerencia);
}
