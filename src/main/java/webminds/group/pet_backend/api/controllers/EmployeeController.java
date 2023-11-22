package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.service.ServicePet;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.domain.user.Employee;
import webminds.group.pet_backend.services.petShop.PetShopService;
import webminds.group.pet_backend.services.service.AssignmentServiceEmployeeService;
import webminds.group.pet_backend.services.service.ServicePetService;
import webminds.group.pet_backend.services.service.dto.AssignmentServiceEmployeeCreationDto;
import webminds.group.pet_backend.services.service.dto.mapper.AssignmentServiceEmployeeMapper;
import webminds.group.pet_backend.services.user.client.UserService;
import webminds.group.pet_backend.services.user.employee.EmployeeService;
import webminds.group.pet_backend.services.user.employee.dto.EmployeeUserAuthCreationDto;
import webminds.group.pet_backend.services.user.employee.dto.mapper.EmployeeMapper;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/funcionarios")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final UserService userService;
    private final PetShopService petShopService;
    private final ServicePetService servicePetService;
    private final AssignmentServiceEmployeeService assignmentServiceEmployeeService;

    @PostMapping("/{id}")
    private ResponseEntity<Void> create(@RequestBody @Valid EmployeeUserAuthCreationDto employeeUserAuthCreationDto, @PathVariable Long id){

//        if (employeeUserAuthCreationDto.getListIdService().size() != employeeUserAuthCreationDto.getListTimeWork().size()){
//            return ResponseEntity.badRequest().build();
//        }
        Optional<PetShop> petShop = this.petShopService.getByUser(id);

        if (petShop.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        AuthUser user = this.userService.createAuthUser(EmployeeMapper.ofCreationAuth(employeeUserAuthCreationDto));
        this.employeeService.createEmployee(EmployeeMapper.ofCreation(employeeUserAuthCreationDto, user, petShop.get()));

        return ResponseEntity.created(null).build();
    }

    @PostMapping("/servicos")
    private ResponseEntity<Void> createService(@RequestBody @Valid AssignmentServiceEmployeeCreationDto assignmentServiceEmployeeCreationDto){

        Optional<Employee> employee = employeeService.getById(assignmentServiceEmployeeCreationDto.getEmployee());
        if(employee.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        Optional<ServicePet> servicePet = servicePetService.getById(assignmentServiceEmployeeCreationDto.getService());
        if(servicePet.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        assignmentServiceEmployeeService.create(AssignmentServiceEmployeeMapper.ofCreationAssignment(servicePet.get(), employee.get(), assignmentServiceEmployeeCreationDto.getTimeWork()));

        return ResponseEntity.created(null).build();
    }

}
