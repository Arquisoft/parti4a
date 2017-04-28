package participationSystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import participationSystem.domain.Categoria;
import participationSystem.domain.Citizen;
import participationSystem.services.CitizenService;
import participationSystem.util.exception.CitizenException;
import repository.CategoryRepository;
import repository.CitizenRepository;

import java.util.List;

@Service
public class CitizenServiceImpl implements CitizenService {

	private CitizenRepository citizenRepository;
	private CategoryRepository categoryRepository;

	@Autowired
	public void setCitizenRepository(CitizenRepository citizenRepository) {
		this.citizenRepository = citizenRepository;
	}
	

	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

//	@Override
//	public void createSugerencia(Sugerencia sug) throws CitizenException {
//		// boolean catBien = systemServices.existeLaCategoria(categoria);
//		// boolean nombreYcontenidoBien =
//		// (systemServices.contienePalabrasAdmitidas(contenido)
//		// || systemServices.contienePalabrasAdmitidas(nombre)) ? false : true;
//
//		try {
//			this.suggestionRepository.save(sug);
//			// Mandar a Kafka (ejemplo que no tiene por qué ser asi)
//			logger.send(Topics.CREATE_SUGGESTION,
//					sug.getNombre() + separator + sug.getContenido() + separator + sug.getCategoria());
//			loggerCutre.log(this.getClass(), "Sugerencia = " + sug.getNombre(), "Categoria = " + sug.getCategoria().getNombre());
//		} catch (Exception e) {
//			throw new CitizenException("Error al guardar lasugerencia.");
//		}
//
//	}

//	@Override
//	public void createComentario(Comentario comment) throws CitizenException {
//		// boolean sugBien = systemServices.existeLaSugerencia(sugerencia);
//		// boolean commentBien =
//		// (systemServices.contienePalabrasAdmitidas(contenido)) ? false : true;
//		// boolean todoOK = (commentBien && sugBien) ? true : false;
//		try {
//
//			// addComentario(comentario);
//			this.commentRepository.save(comment);
//			logger.send(Topics.COMMENT_SUGGESTION,
//					comment.getSugerencia().getId() + separator + comment.getContenido());
//			loggerCutre.log(this.getClass(), "Comentario ID = " + comment.getId());
//		} catch (Exception e) {
//			throw new CitizenException("Error al crear un comentario.");
//		}
//
//	}

	@Override
	public List<Categoria> getCategoriasDisponibles() throws CitizenException {
		//SystemServices ss = new SystemServicesImpl();
		return categoryRepository.findAll();
	}

//	@Override
//	public void createCategoria(Categoria categoria) throws CitizenException {
//		// SystemServices ss = new SystemServicesImpl();
//		this.categoryRepository.findByNombre(categoria.getNombre());
//		if (this.categoryRepository.findByNombre(categoria.getNombre()) == null)
//			this.categoryRepository.save(categoria);
//		else {
//			throw new CitizenException("Ha ocurrido un error al crear la categoría.");
//
//		}
//
//	}

	



	@Override
	public Citizen getCitizen(String email) {
		Citizen c = this.citizenRepository.findByEmail(email);
		return c;
	}

/*	@Override
	public void votePositiveSuggestion(Sugerencia suggestion, Citizen ciudadano) throws CitizenException {
		if(this.suggestionRepository.findOne(suggestion.getId()) == null){
			loggerCutre.log(this.getClass(), "La sugerencia con nombre: "+suggestion.getNombre() +" no existe.");
			throw new CitizenException("La sugerencia no existe.");
		}
		suggestion.addCiudadanoHaVotado(ciudadano);
		suggestion.incrementarVotos();
		logger.send(Topics.POSITIVE_SUGGESTION_VOTE, suggestion.getId() + "");
		loggerCutre.log(this.getClass(), "El ciudadano con ID: "+ciudadano.getId()+", Votando postivo a sugerencia ID: "+suggestion.getId());

	}

	*/

}
