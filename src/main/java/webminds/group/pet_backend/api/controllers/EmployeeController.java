package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.service.AssignmentServiceEmployee;
import webminds.group.pet_backend.domain.service.ServicePet;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.domain.user.Employee;
import webminds.group.pet_backend.services.petShop.PetShopService;
import webminds.group.pet_backend.services.service.AssignmentServiceEmployeeService;
import webminds.group.pet_backend.services.service.ServicePetService;
import webminds.group.pet_backend.services.service.dto.AssignmentServiceEmployeeCreationDto;
import webminds.group.pet_backend.services.service.dto.AssignmentServiceEmployeeDto;
import webminds.group.pet_backend.services.service.dto.mapper.AssignmentServiceEmployeeMapper;
import webminds.group.pet_backend.services.user.client.UserService;
import webminds.group.pet_backend.services.user.employee.EmployeeService;
import webminds.group.pet_backend.services.user.employee.dto.EmployeeDto;
import webminds.group.pet_backend.services.user.employee.dto.EmployeeUserAuthCreationDto;
import webminds.group.pet_backend.services.user.employee.dto.ScheduledTime;
import webminds.group.pet_backend.services.user.employee.dto.mapper.EmployeeMapper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/funcionarios")
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

        Optional<PetShop> petShop = this.petShopService.getByUser(idOwner);

        if (petShop.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        AuthUser user = this.userService.createAuthUser(EmployeeMapper.ofCreationAuth(employeeUserAuthCreationDto));
        this.employeeService.createEmployee(EmployeeMapper.ofCreation(employeeUserAuthCreationDto, user, petShop.get()));

        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{idOwner}/{id}")
    private ResponseEntity<Void> update(@RequestBody @Valid EmployeeUserAuthCreationDto employeeUserAuthCreationDto, @PathVariable Long idOwner, @PathVariable Long id){
        Optional<PetShop> petShop = this.petShopService.getByUser(idOwner);
        if (petShop.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Optional<Employee> employee = employeeService.getById(id);

        if (employee.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        AuthUser user = this.userService.update(EmployeeMapper.ofCreationAuth(employeeUserAuthCreationDto), employee.get().getAuthUser().getId());
        this.employeeService.update(EmployeeMapper.ofCreation(employeeUserAuthCreationDto, user, petShop.get()), id);

        return ResponseEntity.ok().build();
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

    @GetMapping("/servicos/{idService}")
    private ResponseEntity<List<AssignmentServiceEmployeeDto>> getByService(@PathVariable Long idService){
        List<AssignmentServiceEmployee> all = assignmentServiceEmployeeService.getByService(idService);
        if (all.isEmpty()){
            return ResponseEntity.noContent().build();
        }


        return ResponseEntity.ok().body(all.stream().map(AssignmentServiceEmployeeMapper::of).toList());
    }

    @PutMapping("/servicos/{id}")
    private ResponseEntity<Void> updateService(@RequestBody @Valid AssignmentServiceEmployeeCreationDto assignmentServiceEmployeeCreationDto, @PathVariable Long id){
        Optional<Employee> employee = employeeService.getById(assignmentServiceEmployeeCreationDto.getIdEmployee());
        if(employee.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        Optional<ServicePet> servicePet = servicePetService.getById(assignmentServiceEmployeeCreationDto.getIdService());
        if(servicePet.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        assignmentServiceEmployeeService.update(AssignmentServiceEmployeeMapper.ofCreationAssignment(servicePet.get(), employee.get(), assignmentServiceEmployeeCreationDto.getTimeWork()), id);

        return null;
    }

    @DeleteMapping("/servicos/{id}")
    private ResponseEntity<Void> deleteService(@PathVariable Long id){
        assignmentServiceEmployeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/horarios-agendados/{id}")
    private ResponseEntity<List<ScheduledTime>> getTest(@PathVariable Long id, @RequestParam String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateForm = LocalDate.parse(date, formatter);
       return ResponseEntity.ok().body(employeeService.getTest(id, dateForm));
    }

}
