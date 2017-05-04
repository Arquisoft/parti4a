package participationSystem.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import participationSystem.services.AdminService;
import repository.ConfigurationRepository;
import repository.SuggestionRepository;
import repository.domain.Configuration;
import repository.domain.Sugerencia;

/**
 * 
 * Servicios que necesia el adminsitrador del sistema.
 *
 */
@Service
public class AdminServiceImpl implements AdminService {
	private SuggestionRepository suggestionRepository;
	private ConfigurationRepository configurationRepository;

	@Override
	public Configuration getConfiguracion() {
		// // ANA Obtener configuracion
		// return null;
		Long id = new Long(1);
		Configuration config = this.configurationRepository.findOne(id);
		List<Configuration> listado = this.configurationRepository.findAll();
		if (listado.size() == 0 || config == null) {
			loggerCutre.log(getClass(), "No hay configuraciones asi que vamos a crear una nueva.");
			Configuration newC = new Configuration();
			this.configurationRepository.save(newC);
			return newC;
		}
		return config;
	}

	@Autowired
	public void setConfigurationRepository(ConfigurationRepository configurationRepository) {
		this.configurationRepository = configurationRepository;
	}



	@Autowired
	public void setSuggestionRepository(SuggestionRepository suggestionRepository) {
		this.suggestionRepository = suggestionRepository;
	}

	@Override
	public void setConfiguracion(Configuration config) {
		// configurationRepository.save(new Configuration("mierda"));
		// configurationRepository.save(new Configuration("puta"));
		// configurationRepository.save(new Configuration("polla"));
		// configurationRepository.save(new Configuration("gilipollas"));
		// configurationRepository.save(new Configuration("hostia"));
		// configurationRepository.save(new Configuration("cabrón"));
		// configurationRepository.save(new Configuration("subnormal"));
		// configurationRepository.save(new Configuration("coño"));
		// configurationRepository.save(new Configuration("joder"));
		// ANA Establece la configuracion par ala base de datos
		// Configuration antigua = getConfiguracion();
		// this.configurationRepository.delete(antigua);
		this.configurationRepository.deleteAll();
		this.configurationRepository.save(config);
		loggerCutre.log(getClass(), "Se han borrado todas las configuraciones y se ha añadido una nueva.");
	}

	@Override
	public void updateConfiguracion(Configuration config) {
		this.configurationRepository.save(config);
		loggerCutre.log(getClass(), "Se ha actualizado la configuracion del sistema.");

	}

	@Override
	public void addPalabraProhibida(String word) {
		try {
			Configuration antigua = getConfiguracion();
			loggerCutre.log(getClass(), "Tengo estas palabras en la config "+antigua.getPalabraNoPermitida());
			antigua.addPalabraNoPermitida(word);
			updateConfiguracion(antigua);
			loggerCutre.log(getClass(),
					"Se ha añadido una palabra prohibida, ahora tengo: \n\n\t" + antigua.getPalabraNoPermitida());
		} catch (Exception e) {
			loggerCutre.log(getClass(), "ERROR al añadir una palabra: \n\n\t" + e.getMessage());
		}
	}

	@Override
	public Sugerencia editarSugerencia(Sugerencia antigua, String nuevoNombre, String nuevoContenido) {
		if (!"".equals(nuevoNombre) || nuevoNombre != null) {
			antigua.setNombre(nuevoNombre);
		}
		if (!"".equals(nuevoContenido) || nuevoContenido != null) {
			antigua.setContenido(nuevoContenido);
		}
		suggestionRepository.save(antigua);

		return antigua;
	}

	@Override
	public void setMinimoVotos(int minVotes) {
		Configuration config = getConfiguracion();
		config.setMinimoVotos(minVotes);
		updateConfiguracion(config);
		loggerCutre.log(getClass(), "Se ha actualizado el minimo de votos a " + minVotes);
	}

	@Override
	public int getMinimoVotos() {
		Configuration config = getConfiguracion();
		int value = config.getMinimoVotos();
		loggerCutre.log(getClass(), "El numero de votos minimos de la configuracion es " + value);

		return value;
	}

}
