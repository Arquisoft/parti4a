package participationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import participationSystem.domain.Configuration;

@Repository("configurationRepository")
public interface ConfigurationRepository extends JpaRepository<Configuration, Long>{

}
