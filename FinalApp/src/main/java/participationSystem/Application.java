package participationSystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EntityScan
@EnableJpaRepositories("repository")
public class Application {
	private static ConfigurableApplicationContext applicationInstance;
    public static void main(String[] args) {
    	applicationInstance = SpringApplication.run(Application.class, args);
//        Configuration config = Services.getSystemServices().getConfiguration();

    }
    
    public static ConfigurableApplicationContext getAppInstance(){
    	return applicationInstance;
    }
}	