package yanr.inventory.employeeservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/**
 * TODO add gin number
 * @author Melton Smith
 * @since 17.09.2020
 */
@Data
@RequiredArgsConstructor
@Document
public class Employee {
    @Id
    private String id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String birthDate;

    private String middleName;
}
