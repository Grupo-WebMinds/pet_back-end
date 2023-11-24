package webminds.group.pet_backend.services.scheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webminds.group.pet_backend.services.service.dto.ServicePetDto;
import webminds.group.pet_backend.services.user.employee.dto.EmployeeDto;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentServiceEmployeeSchedulingDto {

    private LocalTime timeWork;
    private ServicePetDto servicePetDto;
    private EmployeeDto employeeDto;

}
