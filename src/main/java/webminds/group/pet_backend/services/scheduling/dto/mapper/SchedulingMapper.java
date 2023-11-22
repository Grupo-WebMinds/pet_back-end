package webminds.group.pet_backend.services.scheduling.dto.mapper;

import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.scheduling.Scheduling;
import webminds.group.pet_backend.domain.service.AssignmentServiceEmployee;
import webminds.group.pet_backend.services.scheduling.dto.SchedulingCreationDto;

public class SchedulingMapper {

    public static Scheduling ofCreation(SchedulingCreationDto schedulingCreationDto, Pet pet, AssignmentServiceEmployee assignmentServiceEmployee){
        Scheduling scheduling = new Scheduling();
        scheduling.setDateScheduling(schedulingCreationDto.getDateScheduling());
        scheduling.setObservation(schedulingCreationDto.getObservation());
        scheduling.setPet(pet);
        scheduling.setAssignmentServiceEmployee(assignmentServiceEmployee);

        return scheduling;
    }

}
