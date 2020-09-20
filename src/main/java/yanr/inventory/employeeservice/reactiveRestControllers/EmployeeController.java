package yanr.inventory.employeeservice.reactiveRestControllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import yanr.inventory.employeeservice.domain.Employee;
import yanr.inventory.employeeservice.reactiveRepos.EmployeeReactiveRepository;

/**
 * @author Melton Smith
 * @since 19.09.2020
 */
@RestController
@RequestMapping(path = "/employee", produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployeeController {
    private final EmployeeReactiveRepository employeeReactiveRepository;

    public EmployeeController(EmployeeReactiveRepository tacoRepo) {
        this.employeeReactiveRepository = tacoRepo;
    }

    @GetMapping
    public Flux<Employee> employees() {
        return employeeReactiveRepository.findAll().take(12);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Employee> postEmployee(@RequestBody Employee employee) {
        return employeeReactiveRepository.save(employee);
    }
//
//    @GetMapping("/{id}")
//    public Mono<Taco> tacoById(@PathVariable("id") UUID id) {
//        return tacoRepo.findById(id);
//    }
}
