package hello.repository;

import hello.domain.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Pelayo García Lartategui on 27/03/2017.*/


    @Repository("citizenRepository")
    public interface CitizenRepository extends JpaRepository<Citizen,Long> {

        Citizen findByEmail(String email);

    }

