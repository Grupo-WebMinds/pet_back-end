package webminds.group.pet_backend.services.service.dto.mapper;

import webminds.group.pet_backend.domain.service.AssignmentServiceEmployee;
import webminds.group.pet_backend.domain.service.ServicePet;
import webminds.group.pet_backend.domain.user.Employee;
import webminds.group.pet_backend.services.service.dto.AssignmentServiceEmployeeDto;
import webminds.group.pet_backend.services.user.employee.dto.mapper.EmployeeMapper;

import java.time.LocalTime;

public class AssignmentServiceEmployeeMapper {

    public static AssignmentServiceEmployee ofCreationAssignment(ServicePet servicePet, Employee employee, LocalTime timeWork){
        AssignmentServiceEmployee assignmentServiceEmployee = new AssignmentServiceEmployee();

        assignmentServiceEmployee.setServicePet(servicePet);
        assignmentServiceEmployee.setEmployee(employee);
        assignmentServiceEmployee.setTimeWork(timeWork);

        return assignmentServiceEmployee;
    }

    public static AssignmentServiceEmployeeDto of(AssignmentServiceEmployee assignmentServiceEmployee){
        AssignmentServiceEmployeeDto dto = new AssignmentServiceEmployeeDto();
        dto.setId(assignmentServiceEmployee.getId());
        dto.setTimeWork(assignmentServiceEmployee.getTimeWork());
        dto.setEmployeeDto(EmployeeMapper.of(assignmentServiceEmployee.getEmployee()));
        return dto;
    }

}
