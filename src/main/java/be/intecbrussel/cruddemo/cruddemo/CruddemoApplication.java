package be.intecbrussel.cruddemo.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
//@ComponentScan(basePackages={"be.intecbrussel.cruddemo.cruddemo"})
@EnableJpaRepositories(basePackages = "be.intecbrussel.cruddemo.cruddemo.repositories")
@EnableTransactionManagement
@EntityScan(basePackages = "be.intecbrussel.cruddemo.cruddemo.entities")
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

}
