package es.uniovi.asw.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.domain.Categoria;
import es.uniovi.asw.domain.Configuration;
import es.uniovi.asw.domain.Sugerencia;
import es.uniovi.asw.repository.CategoryRepository;
import es.uniovi.asw.repository.CommentRepository;
import es.uniovi.asw.repository.ConfigurationRepository;
import es.uniovi.asw.repository.SuggestionRepository;
import es.uniovi.asw.services.SystemServices;

@Service
public class SystemServicesImpl implements SystemServices {

	private ConfigurationRepository configurationRepository;
	private CommentRepository commentRepository;
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
	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
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
		// Obtener de la base de datos y actualizar la lista
		List<Categoria> categorias = this.categoryRepository.findAll();
		return categorias;
	}

	@Override
	public boolean contienePalabrasNoAdmitidas(String mensaje) {
		List<String> wordsNotAllowed = new ArrayList<String>();
		Configuration c = getConfiguration();
		wordsNotAllowed = c.getPalabrasNoPermitidas();
		String[] myWordsTemp = mensaje.split(" ");

		for (int i = 0; i < myWordsTemp.length; i++) {
			if (wordsNotAllowed.contains(myWordsTemp[i])) {
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
		return (s != null);
	}

}
