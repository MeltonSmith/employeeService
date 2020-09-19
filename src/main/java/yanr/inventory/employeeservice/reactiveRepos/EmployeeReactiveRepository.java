package yanr.inventory.employeeservice.reactiveRepos;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import yanr.inventory.employeeservice.domain.Employee;

/**
 * @author Melton Smith
 * @since 17.09.2020
 */
public interface EmployeeReactiveRepository extends ReactiveCrudRepository<Employee, String> {
}
