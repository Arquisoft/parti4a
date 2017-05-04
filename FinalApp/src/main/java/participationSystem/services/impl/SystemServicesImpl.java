package participationSystem.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import participationSystem.services.SystemServices;
import repository.CategoryRepository;
import repository.ConfigurationRepository;
import repository.SuggestionRepository;
import repository.domain.Categoria;
import repository.domain.Configuration;
import repository.domain.Sugerencia;

@Service
public class SystemServicesImpl implements SystemServices {

	//private Configuration config = null;
	private ConfigurationRepository configurationRepository;
	private SuggestionRepository suggestionRepository;
	private CategoryRepository categoryRepository;
	
	
	public Configuration getConfiguration() {
		List<Configuration> listado = this.configurationRepository.findAll();
		if (listado.size() == 0) {
			loggerCutre.log(getClass(), "No hay configuraciones asi que vamos a crear una nueva.");
			Configuration newC = new Configuration();
			this.configurationRepository.save(newC);
			return newC;
		}
		return listado.get(0);
	}
	
	
	@Autowired
	public void setConfigurationRepository(ConfigurationRepository configurationRepository) {
		this.configurationRepository = configurationRepository;
	}

	@Autowired
	public void setSuggestionRepository(SuggestionRepository suggestionRepository) {
		this.suggestionRepository = suggestionRepository;
	}

	
	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}


	@Override
	public List<Categoria> getAllCategories() {
		// TODO Auto-generated method stub
		//Obtener de la  base de datos y actualizar la lista
		List<Categoria> categorias= this.categoryRepository.findAll();
		return categorias;
	}

	@Override
	public boolean contienePalabrasNoAdmitidas(String mensaje) {
		List<String> wordsNotAllowed = new ArrayList<String>();
		Configuration c = getConfiguration();
		wordsNotAllowed = c.getPalabrasNoPermitidas();
		String[] myWordsTemp = mensaje.split(" "); 

		for(int i = 0; i < myWordsTemp.length; i++){
			if(wordsNotAllowed.contains(myWordsTemp[i])){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean existeLaCategoria(Categoria cat) {
		List<Categoria> categorias = categoryRepository.findAll();
		return categorias.contains(cat);
	}

	@Override
	public boolean existeLaSugerencia(Sugerencia sugerencia) {
		Sugerencia s = this.suggestionRepository.findOne(sugerencia.getId());
		return (s!=null);
	}

}
