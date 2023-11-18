package webminds.group.pet_backend.services.user.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserDto {

    private String name;
    private String email;
    private Short userType;
    private String cellPhone;
    private String telephone;
    private LocalDate dateBirth;
    private String cpf;
    private LocalDateTime dateCreation;

}
