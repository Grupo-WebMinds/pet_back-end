package webminds.group.pet_backend.services.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webminds.group.pet_backend.services.user.client.dto.AuthUserDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {

    private Long id;
    private String name;
    private String typePet;
    private String race;
    private Double weight;
    private Short size;
    private Short gender;
    private LocalDate dateBirth;
    private LocalDateTime dateCreation;
    private AuthUserDto authUserDto;

}
