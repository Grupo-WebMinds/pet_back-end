package webminds.group.pet_backend.services.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentServiceEmployeeCreationDto {

    private LocalTime timeWork;
    private Long service;
    private Long employee;

}
