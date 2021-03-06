package es.uniovi.asw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.domain.Citizen;


/**
 * Created by Pelayo García Lartategui on 27/03/2017.*/


    @Repository("citizenRepository")
    public interface CitizenRepository extends JpaRepository<Citizen,Long> {

        Citizen findByEmail(String email);

    }

