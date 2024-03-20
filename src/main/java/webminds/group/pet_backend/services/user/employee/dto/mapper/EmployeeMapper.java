package webminds.group.pet_backend.services.user.employee.dto.mapper;

import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.domain.user.Employee;
import webminds.group.pet_backend.services.user.client.dto.mapper.AuthUserMapper;
import webminds.group.pet_backend.services.user.employee.dto.EmployeeDto;
import webminds.group.pet_backend.services.user.employee.dto.EmployeeUserAuthCreationDto;

import java.time.LocalDateTime;

public class EmployeeMapper {

    public static Employee ofCreation(EmployeeUserAuthCreationDto newUser, AuthUser user, PetShop pet){
        Employee dto = new Employee();
        dto.setTimeEnd(newUser.getTimeEnd());
        dto.setTimeStart(newUser.getTimeStart());
        dto.setAuthUser(user);
        dto.setPetShop(pet);

        return dto;
    }

    public static AuthUser ofCreationAuth(EmployeeUserAuthCreationDto newUser){
        AuthUser dto = new AuthUser();

        dto.setName(newUser.getName());
        dto.setPassword(newUser.getPassword());
        dto.setEmail(newUser.getEmail());
        dto.setCpf(newUser.getCpf());
        dto.setUserType((short) 3);
        dto.setCellPhone(newUser.getCellPhone());
        dto.setTelephone(newUser.getTelephone());
        dto.setDateBirth(newUser.getDateBirth());
        dto.setGender(newUser.getGender());
        dto.setDateCreation(LocalDateTime.now());

        return dto;
    }

    public static EmployeeDto of(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setTimeStart(employee.getTimeStart());
        dto.setTimeEnd(employee.getTimeEnd());
        dto.setAuthUserDto(AuthUserMapper.ofDto(employee.getAuthUser()));

        return dto;
    }



}
