package webminds.group.pet_backend.services.user.authentication.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserLoginDto {

    @Schema(description = "E-mail do usuário", example = "john@doe.com")
    private String email;

    @Schema(description = "Senha do usuário", example = "123456")
    private String password;

}
