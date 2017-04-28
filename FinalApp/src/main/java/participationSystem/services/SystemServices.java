package participationSystem.services;

import java.util.List;

import participationSystem.domain.Categoria;
import participationSystem.domain.Configuration;
import participationSystem.domain.Sugerencia;



public interface SystemServices extends SuperService{

	Configuration getConfiguration();
	List<Categoria> getAllCategories();
	boolean contienePalabrasNoAdmitidas(String mensaje);
	boolean existeLaCategoria(Categoria cat);
	boolean existeLaSugerencia(Sugerencia sugerencia);
}
