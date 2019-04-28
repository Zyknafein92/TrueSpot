package truespot.webapp.StartDemoApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import truespot.business.contract.UserManager;
import truespot.model.User;

@SpringBootApplication
@EntityScan(basePackages = "truespot.model")
@EnableJpaRepositories(basePackages = "truespot.consumer")
@ComponentScan(basePackages = "truespot")
public class DemoApplication{

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
    }
    
}
