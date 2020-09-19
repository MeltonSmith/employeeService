package yanr.inventory.employeeservice.reactiveRestControllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
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
    private EmployeeReactiveRepository employeeReactiveRepository;

    public EmployeeController(EmployeeReactiveRepository tacoRepo) {
        this.employeeReactiveRepository = tacoRepo;
    }

    @GetMapping
    public Flux<Employee> recentTacos() {
        return employeeReactiveRepository.findAll().take(12);
    }

//    @PostMapping(consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Mono<Taco> postTaco(@RequestBody Taco taco) {
//        return tacoRepo.save(taco);
//    }
//
//    @GetMapping("/{id}")
//    public Mono<Taco> tacoById(@PathVariable("id") UUID id) {
//        return tacoRepo.findById(id);
//    }
}
