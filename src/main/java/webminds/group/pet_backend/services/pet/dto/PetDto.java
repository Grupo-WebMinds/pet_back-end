package webminds.group.pet_backend.services.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {

    private String name;
    private String typePet;
    private String race;
    private Double weight;
    private Short size;
    private Short gender;
    private LocalDate dateBirth;
    private LocalDateTime dateCreation;

}
