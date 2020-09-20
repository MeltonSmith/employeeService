package yanr.inventory.employeeservice.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yanr.inventory.employeeservice.domain.Employee;
import yanr.inventory.employeeservice.reactiveRepos.EmployeeReactiveRepository;

import java.io.IOException;
import java.util.UUID;

/**
 * @author Melton Smith
 * @since 20.09.2020
 */
@AutoConfigureAfter(value = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@Configuration
public class MongoAutoFillConfigurationClass {

    @Bean
    @SuppressWarnings("unchecked")
    public Boolean preFill(EmployeeReactiveRepository reactiveRepository) throws IOException {
        reactiveRepository.save(mockkEmployee((long)(Math.random() * 100L)));
        reactiveRepository.save(mockkEmployee((long)(Math.random() * 100L)));
        reactiveRepository.save(mockkEmployee((long)(Math.random() * 100L)));
        reactiveRepository.save(mockkEmployee((long)(Math.random() * 100L)));
        reactiveRepository.save(mockkEmployee((long)(Math.random() * 100L)));
        reactiveRepository.save(mockkEmployee((long)(Math.random() * 100L)));

        return true;
    }

    private Employee mockkEmployee(Long number) {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setFirstName("First name =" +  number);
        employee.setLastName("Second name =" +  number);
        employee.setMiddleName("Middle name =" +  number);
        employee.setBirthDate("Birth date = "  + number);


//        List<IngredientUDT> ingredients = new ArrayList<>();
//        ingredients.add(
//                new IngredientUDT("INGA", "Ingredient A", Type.WRAP));
//        ingredients.add(
//                new IngredientUDT("INGB", "Ingredient B", Type.PROTEIN));
//        taco.setIngredients(ingredients);
        return employee;
    }
//
//    @Bean
//    public Mongobee mongobee(){
//        Mongobee runner = new Mongobee("mongodb://localhost:12345/employee");
////        runner.setDbName("yourDbName");         // host must be set if not set in URI
//        runner.setChangeLogsScanPackage(
//                "yanr.inventory.employeeservice.prefill"); // the package to be scanned for changesets
//
//        return runner;
//    }

}
