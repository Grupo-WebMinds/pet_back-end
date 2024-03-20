package webminds.group.pet_backend.services.scheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webminds.group.pet_backend.services.pet.dto.PetDto;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingDto {

    private LocalDateTime dateScheduling;
    private String observation;
    private PetDto petDto;
    private AssignmentServiceEmployeeSchedulingDto assignmentServiceEmployeeSchedulingDto;

}
