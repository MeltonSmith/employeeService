package yanr.inventory.employeeservice.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;
import yanr.inventory.employeeservice.domain.Employee;
import yanr.inventory.employeeservice.reactiveRepos.EmployeeReactiveRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Melton Smith
 * @since 20.09.2020
 */
@AutoConfigureAfter(value = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@Configuration
public class MongoAutoFillConfigurationClass {
    //Appear to be working!
    @Bean
    @SuppressWarnings("unchecked")
    public Boolean preFill(EmployeeReactiveRepository reactiveRepository) throws IOException {
        Mono<Long> fill = fill(reactiveRepository);

        fill.subscribe(System.out::println);

        return true;
    }

    private Mono<Long> fill(EmployeeReactiveRepository reactiveRepository)
    {
        List<Employee> employeesToInsert = new ArrayList<>();

        for (int i=0; i< 100; i ++)
            employeesToInsert.add(mockEmployee((long)(Math.random() * 100L)));

        return reactiveRepository.saveAll(employeesToInsert).count();
    }


    private Employee mockEmployee(Long number) {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setFirstName("First name =" +  number);
        employee.setLastName("Second name =" +  number);
        employee.setMiddleName("Middle name =" +  number);
        employee.setBirthDate("Birth date = "  + number);
        return employee;
    }
}
