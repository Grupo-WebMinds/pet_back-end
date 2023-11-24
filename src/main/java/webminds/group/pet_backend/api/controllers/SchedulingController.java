package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.scheduling.Scheduling;
import webminds.group.pet_backend.domain.service.AssignmentServiceEmployee;
import webminds.group.pet_backend.services.pet.PetService;
import webminds.group.pet_backend.services.scheduling.SchedulingService;
import webminds.group.pet_backend.services.scheduling.dto.SchedulingCreationDto;
import webminds.group.pet_backend.services.scheduling.dto.SchedulingDto;
import webminds.group.pet_backend.services.scheduling.dto.mapper.SchedulingMapper;
import webminds.group.pet_backend.services.service.AssignmentServiceEmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamentos")
public class SchedulingController {

    private final PetService petService;
    private final AssignmentServiceEmployeeService assignmentServiceEmployeeService;
    private final SchedulingService schedulingService;

//    @GetMapping
//    private ResponseEntity<List<SchedulingDto>> get() {
//        List<Scheduling> all = schedulingService.get();
//
//        if (all.isEmpty()){
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.ok(all.stream().map().toList());
//    }

    @PostMapping
    private ResponseEntity<Void> create(@RequestBody @Valid SchedulingCreationDto schedulingCreationDto){

        Optional<Pet> pet = petService.getById(schedulingCreationDto.getIdPet());

        if (pet.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        Optional<AssignmentServiceEmployee> assignmentServiceEmployee = assignmentServiceEmployeeService.getById(schedulingCreationDto.getIdAssignment());

        if(assignmentServiceEmployee.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        schedulingService.create(SchedulingMapper.ofCreation(schedulingCreationDto, pet.get(), assignmentServiceEmployee.get()));

        return ResponseEntity.created(null).build();
    }

}
