package com.asw.citizensLoader.dbupdate;


import java.util.List;

import com.asw.citizensLoader.model.Citizen;


/**
 * Recibe un objeto con la información para insertar en la base de datos.
 */
public interface Insert {
	
	void insert(List<Citizen> ciudadanos);
}
