package webminds.group.pet_backend.services.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserDto {

    private String email;

    private short userType;

    private UserResponseDto user;

}
