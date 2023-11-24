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
import webminds.group.pet_backend.services.user.employee.dto.EmployeeDto;
import webminds.group.pet_backend.services.user.employee.dto.EmployeeUserAuthCreationDto;
import webminds.group.pet_backend.services.user.employee.dto.mapper.EmployeeMapper;

import java.util.List;
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

    @GetMapping
    private ResponseEntity<List<EmployeeDto>> get(){
        List<Employee> all = employeeService.get();

        if (all.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all.stream().map(EmployeeMapper::of).toList());
    }

    @GetMapping("/{id}")
    private ResponseEntity<EmployeeDto> getById(@PathVariable Long id){
        Optional<Employee> employee = employeeService.getById(id);

        if (employee.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(EmployeeMapper.of(employee.get()));
    }


    @PostMapping("/{idOwner}")
    private ResponseEntity<Void> create(@RequestBody @Valid EmployeeUserAuthCreationDto employeeUserAuthCreationDto, @PathVariable Long idOwner){

//        if (employeeUserAuthCreationDto.getListIdService().size() != employeeUserAuthCreationDto.getListTimeWork().size()){
//            return ResponseEntity.badRequest().build();
//        }
        Optional<PetShop> petShop = this.petShopService.getByUser(idOwner);

        if (petShop.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        AuthUser user = this.userService.createAuthUser(EmployeeMapper.ofCreationAuth(employeeUserAuthCreationDto));
        this.employeeService.createEmployee(EmployeeMapper.ofCreation(employeeUserAuthCreationDto, user, petShop.get()));

        return ResponseEntity.created(null).build();
    }

    @PostMapping("/servicos")
    private ResponseEntity<Void> createService(@RequestBody @Valid AssignmentServiceEmployeeCreationDto assignmentServiceEmployeeCreationDto){

        Optional<Employee> employee = employeeService.getById(assignmentServiceEmployeeCreationDto.getIdEmployee());
        if(employee.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        Optional<ServicePet> servicePet = servicePetService.getById(assignmentServiceEmployeeCreationDto.getIdService());
        if(servicePet.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        assignmentServiceEmployeeService.create(AssignmentServiceEmployeeMapper.ofCreationAssignment(servicePet.get(), employee.get(), assignmentServiceEmployeeCreationDto.getTimeWork()));

        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
