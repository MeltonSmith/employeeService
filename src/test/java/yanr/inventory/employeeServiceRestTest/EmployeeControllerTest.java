package yanr.inventory.employeeServiceRestTest;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import yanr.inventory.employeeservice.domain.Employee;
import yanr.inventory.employeeservice.reactiveRepos.EmployeeReactiveRepository;
import yanr.inventory.employeeservice.reactiveRestControllers.EmployeeController;

import java.util.UUID;

/**
 * @author Melton Smith
 * @since 19.09.2020
 */

public class EmployeeControllerTest {


    @Test
    public void shoutReturnEmployees(){
        Employee[] employees = {
                mockkEmployee((long)(Math.random() * 100L)),
                mockkEmployee((long)(Math.random() * 100L)),
                mockkEmployee((long)(Math.random() * 100L)),
                mockkEmployee((long)(Math.random() * 100L)),
                mockkEmployee((long)(Math.random() * 100L)),
                mockkEmployee((long)(Math.random() * 100L)),
                mockkEmployee((long)(Math.random() * 100L)),
                mockkEmployee((long)(Math.random() * 100L)),
        };
        Flux<Employee> a = Flux.just(employees);


        EmployeeReactiveRepository employeeRepoMock = Mockito.mock(EmployeeReactiveRepository.class);
        Mockito.when(employeeRepoMock.findAll()).thenReturn(a);


        WebTestClient testClient = WebTestClient.bindToController(new EmployeeController(employeeRepoMock)).build();

        testClient.get().uri("/employee")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$").isNotEmpty()
                .jsonPath("$[0].id").isEqualTo(employees[0].getId())
                .jsonPath("$[1].id").isEqualTo(employees[1].getId())
                .jsonPath("$[7].id").isEqualTo(employees[7].getId())
                .jsonPath("$[8].id").doesNotExist();


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
}
