package webminds.group.pet_backend.services.scheduling.dto.mapper;

import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.scheduling.Scheduling;
import webminds.group.pet_backend.services.pet.dto.mapper.PetMapper;
import webminds.group.pet_backend.services.scheduling.dto.AssignmentServiceEmployeeSchedulingDto;
import webminds.group.pet_backend.services.scheduling.dto.SchedulingCreationDto;
import webminds.group.pet_backend.services.scheduling.dto.SchedulingDto;
import webminds.group.pet_backend.services.service.dto.mapper.ServicePetMapper;
import webminds.group.pet_backend.services.user.employee.dto.mapper.EmployeeMapper;

public class SchedulingMapper {

//    public static Scheduling ofCreation(SchedulingCreationDto schedulingCreationDto, Pet pet, AssignmentServiceEmployee assignmentServiceEmployee){
//        Scheduling scheduling = new Scheduling();
//        scheduling.setDateScheduling(schedulingCreationDto.getDateScheduling());
//        scheduling.setObservation(schedulingCreationDto.getObservation());
//        scheduling.setPet(pet);
//        scheduling.setAssignmentServiceEmployee(assignmentServiceEmployee);
//
//        return scheduling;
//    }

    public static SchedulingDto of(Scheduling scheduling){
        SchedulingDto dto = new SchedulingDto();
        dto.setDateScheduling(scheduling.getDateScheduling());
        dto.setObservation(scheduling.getObservation());
        dto.setPetDto(PetMapper.of(scheduling.getPet()));
//        dto.setAssignmentServiceEmployeeSchedulingDto(ofAssigment(scheduling.getAssignmentServiceEmployee()));

        return dto;
    }

//    public static AssignmentServiceEmployeeSchedulingDto ofAssigment(AssignmentServiceEmployee assignmentServiceEmployee){
//        AssignmentServiceEmployeeSchedulingDto dto = new AssignmentServiceEmployeeSchedulingDto();
//        dto.setTimeWork(assignmentServiceEmployee.getTimeWork());
//        dto.setServicePetDto(ServicePetMapper.of(assignmentServiceEmployee.getServicePet()));
//        dto.setEmployeeDto(EmployeeMapper.of(assignmentServiceEmployee.getEmployee()));
//
//        return dto;
//    }

}
