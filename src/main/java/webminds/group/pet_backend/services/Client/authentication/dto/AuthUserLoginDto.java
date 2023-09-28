package webminds.group.pet_backend.services.Client.authentication.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class AuthUserLoginDto {

    @Schema(description = "E-mail do usuário", example = "john@doe.com")
    private String email;

    @Schema(description = "Senha do usuário", example = "123456")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
