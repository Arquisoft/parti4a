package com.asw.citizensLoader.dbupdate;



import java.util.List;

import com.asw.citizensLoader.dbupdate.util.Hibernate_Jpa;
import com.asw.citizensLoader.model.Citizen;

/**
 * Created by Pelayo Garcia Lartategui on 10/02/2017.
 * Clase con consultas Hibernate
 */
public class CitizenFinder {

    public static Citizen findByNif(String numero_identificativo){
        List<Citizen> list = Hibernate_Jpa.getManager()
                .createNamedQuery("Citizen.findByNif",Citizen.class)
                .setParameter(1,numero_identificativo).getResultList();
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }
}
