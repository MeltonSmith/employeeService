package yanr.inventory.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Hooks;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class EmployeeserviceApplication {

    public static void main(String[] args) {
        Hooks.onOperatorDebug();
        SpringApplication.run(EmployeeserviceApplication.class, args);
    }

}
