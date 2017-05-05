package hello.services;

import hello.domain.Configuration;
import hello.domain.Sugerencia;

public interface AdminService extends SuperService{
	
	/**
	 * Obtiene la configuracion actual del sistema. 
	 * @return Devuelve un objeto configuracion del modelo de dominio.
	 */
	Configuration getConfiguracion();
	
	/**
	 * Establece una nueva configuracion en el sistema borrando todas las demas. 
	 * @param config
	 */
	void setConfiguracion(Configuration config);
	/**
	 * Actualiza la configuracion actual sin borrar nada de la tabla
	 * @param config
	 */
	void updateConfiguracion(Configuration config);
	
	void addPalabraProhibida(String word);
	/**
	 * Si me pasas null en alguno de los String paso de editarlos. 
	 * @param antigua
	 * @param nuevoNombre
	 * @param nuevoContenido
	 */
	Sugerencia editarSugerencia(Sugerencia antigua, String nuevoNombre, String nuevoContenido);
	
	void setMinimoVotos(int minVotes);
	int getMinimoVotos();
}
