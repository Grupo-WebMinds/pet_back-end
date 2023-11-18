package webminds.group.pet_backend.services.user.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webminds.group.pet_backend.services.petShop.dto.PetShopDto;
import webminds.group.pet_backend.services.user.client.dto.AuthUserDto;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreationDto {

    private LocalTime timeStart;
    private LocalTime timeEnd;

    private AuthUserDto authUserDto;
    private PetShopDto petShopDto;

}
