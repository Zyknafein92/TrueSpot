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
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private UserManager userManager;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {

       userManager.saveUser(new User("Paul","Pierre",21,"male","PoloLeBlaireau","password","Pololeblaireau@gmail.com","025626655",false));
    }
}
