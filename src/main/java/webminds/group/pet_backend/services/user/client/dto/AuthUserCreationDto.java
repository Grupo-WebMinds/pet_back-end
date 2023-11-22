package webminds.group.pet_backend.services.user.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserCreationDto {

    private String name;
    private String email;
    private String password;
    private Short userType;
    private String cellPhone;
    private String telephone;
    private LocalDate dateBirth;
    private String cpf;

}
