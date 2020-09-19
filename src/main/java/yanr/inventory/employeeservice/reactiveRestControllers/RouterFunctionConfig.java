package yanr.inventory.employeeservice.reactiveRestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import yanr.inventory.employeeservice.domain.Employee;
import yanr.inventory.employeeservice.reactiveRepos.EmployeeReactiveRepository;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.Objects;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

/**
 * TODO кусок говна
 * @author Melton Smith
 * @since 17.09.2020
 */
//@Configuration
//public class RouterFunctionConfig {
//    private EmployeeReactiveRepository employeeRepo;
//
//    @Autowired
//    public RouterFunctionConfig(EmployeeReactiveRepository employeeRepo) {
//        this.employeeRepo = employeeRepo;
//    }
//
//    @Bean
//    public RouterFunction<?> routerFunction(){
//        return RouterFunctions
//                .route(GET("/employee") , this::getRecents)
//                .andRoute(POST("/employee"),  this::postEmployee);
//    }
//
//    public Mono<ServerResponse> getRecents(@NotNull ServerRequest request) {
//        return ServerResponse
//                .ok()
////                .body(Mono.just("AAA"), String.class);
//                .body(employeeRepo.findAll().take(12), Employee.class);
//    }
//
//    public Mono<ServerResponse> postEmployee(ServerRequest request) {
//
//        Mono<Employee> employeeMono = request.bodyToMono(Employee.class);
//        Flux<Employee> savedMono = employeeRepo.saveAll(employeeMono);
//        Employee employee = savedMono.blockFirst();
//
//        return ServerResponse
//                .created(URI.create(
//                        "http://localhost:8080/emoloyee/" +
//                                Objects.requireNonNull(employee).getId()))
//                .body(employee, Employee.class);
//    }
//}
