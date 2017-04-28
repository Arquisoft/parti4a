package com.asw.participationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asw.participationSystem.domain.Configuration;

@Repository("configurationRepository")
public interface ConfigurationRepository extends JpaRepository<Configuration, Long>{

}
