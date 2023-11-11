package webminds.group.pet_backend.services.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserAndUserCreationDto {

    private String name;
    private String email;
    private String password;
    private Short userType;
    private String cellPhone;
    private String telephone;
    private LocalDateTime dateBirth;
    private String cpf;
    private LocalDateTime dateCreation;




}
