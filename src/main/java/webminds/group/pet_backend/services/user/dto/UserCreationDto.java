package webminds.group.pet_backend.services.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webminds.group.pet_backend.domain.user.AuthUser;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationDto {

    private String name;
    private String cellPhone;
    private String telephone;
    private LocalDateTime dateBirth;
    private String cpf;
    private LocalDateTime dateCreation;
    private AuthUser authUser;

}
