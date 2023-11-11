package webminds.group.pet_backend.services.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private String name;
    private String cellPhone;
    private String telephone;
    private LocalDateTime dateBirth;
    private String cpf;
    private LocalDateTime dateCreation;

}
