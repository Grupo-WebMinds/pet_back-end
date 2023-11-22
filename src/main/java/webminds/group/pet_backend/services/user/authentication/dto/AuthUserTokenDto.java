package webminds.group.pet_backend.services.user.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserTokenDto {

    private Long userId;
    private String email;
    private Short userType;
    private String token;


}
