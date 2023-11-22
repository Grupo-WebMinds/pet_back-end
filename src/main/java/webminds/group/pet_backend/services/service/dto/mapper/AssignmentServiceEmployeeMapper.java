package webminds.group.pet_backend.services.service.dto.mapper;

import webminds.group.pet_backend.domain.service.AssignmentServiceEmployee;
import webminds.group.pet_backend.domain.service.ServicePet;
import webminds.group.pet_backend.domain.user.Employee;

import java.time.LocalTime;

public class AssignmentServiceEmployeeMapper {

    public static AssignmentServiceEmployee ofCreationAssignment(ServicePet servicePet, Employee employee, LocalTime timeWork){
        AssignmentServiceEmployee assignmentServiceEmployee = new AssignmentServiceEmployee();

        assignmentServiceEmployee.setServicePet(servicePet);
        assignmentServiceEmployee.setEmployee(employee);
        assignmentServiceEmployee.setTimeWork(timeWork);

        return assignmentServiceEmployee;
    }

}
