package com.asw.citizensLoader.parser;



import java.util.List;

import com.asw.citizensLoader.dbupdate.Insert;
import com.asw.citizensLoader.dbupdate.InsertP;
import com.asw.citizensLoader.model.Citizen;



/**
 * Created by Pelayo García Lartategui on 09/02/2017.
 * Implementacion puerto R insersción base de datos
 */
public class InsertR implements Insert {


    @Override
    public void insert(List<Citizen> ciudadanos) {
         new InsertP().insert(ciudadanos);
    }
}
