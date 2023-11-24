package webminds.group.pet_backend.services.user.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUserAuthCreationDto {

    private String name;
    private String email;
    private String password;
    private String cellPhone;
    private String telephone;
    private LocalDate dateBirth;
    private String cpf;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private Short gender;

}
