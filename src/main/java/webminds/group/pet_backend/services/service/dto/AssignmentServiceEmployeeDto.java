package webminds.group.pet_backend.services.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webminds.group.pet_backend.services.user.employee.dto.EmployeeDto;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentServiceEmployeeDto {

    private Long id;
    private LocalTime timeWork;
    private EmployeeDto employeeDto;

}
