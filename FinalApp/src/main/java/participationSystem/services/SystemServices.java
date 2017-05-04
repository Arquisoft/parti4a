package participationSystem.services;

import java.util.List;

import repository.domain.Categoria;
import repository.domain.Configuration;
import repository.domain.Sugerencia;


public interface SystemServices extends SuperService{

	Configuration getConfiguration();
	List<Categoria> getAllCategories();
	boolean contienePalabrasNoAdmitidas(String mensaje);
	boolean existeLaCategoria(Categoria cat);
	boolean existeLaSugerencia(Sugerencia sugerencia);
}
