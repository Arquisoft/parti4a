package es.uniovi.asw.services;

import java.util.List;

import es.uniovi.asw.domain.Categoria;
import es.uniovi.asw.domain.Citizen;
import es.uniovi.asw.domain.Sugerencia;
import es.uniovi.asw.util.exception.CitizenException;

/**
 * Created by pelay on 29/03/2017.
 */
public interface SuggestionService extends SuperService {

    List<Sugerencia>findAll();
    Sugerencia findById(Long id);
    List<Sugerencia>findByCat(Categoria cat);
    void votePositiveSugerencia(Sugerencia sug, Citizen ciudadano) throws CitizenException;
    void voteNegativeSugerencia(Sugerencia sug, Citizen ciudadano) throws CitizenException;
    void createSugerencia(Sugerencia sug) throws CitizenException;
    void createSugerencia(Citizen citizen, Categoria categoria, String titulo, String contenido) throws CitizenException;

    List<Sugerencia> findSugerenciaWithMinVotes();
}
