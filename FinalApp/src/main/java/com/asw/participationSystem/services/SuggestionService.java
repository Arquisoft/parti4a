package com.asw.participationSystem.services;

import com.asw.participationSystem.domain.Categoria;
import com.asw.participationSystem.domain.Citizen;
import com.asw.participationSystem.domain.Sugerencia;
import com.asw.participationSystem.util.exception.CitizenException;

import java.util.List;

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
