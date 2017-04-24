package com.asw.citizensLoader.parser;



import java.util.List;

import com.asw.citizensLoader.model.Citizen;
import com.asw.citizensLoader.util.exception.CitizenException;

/**
 * Lee el fichero con los datos de una lista de ciudadanos.
 * Interfaz de lectura de fichero
 */
public interface ReadList {

    public List<Citizen> read(String path) throws CitizenException;

}
