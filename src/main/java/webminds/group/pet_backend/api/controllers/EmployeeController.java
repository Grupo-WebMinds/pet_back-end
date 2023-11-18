package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.services.petShop.PetShopService;
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

}
