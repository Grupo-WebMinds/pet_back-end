package webminds.group.pet_backend.services.Client.dto;

import webminds.group.pet_backend.domain.client.AuthUser;
import webminds.group.pet_backend.services.Client.authentication.dto.AuthUserTokenDto;

public class AuthUserMapper {

    public static AuthUser of(AuthUserCreationDto authUserCreationDto){
        AuthUser authUser = new AuthUser();

        authUser.setEmail(authUserCreationDto.getEmail());
        authUser.setName(authUserCreationDto.getName());
        authUser.setPassword(authUserCreationDto.getPassword());

        return authUser;
    }

    public static AuthUserTokenDto of(AuthUser authUser, String token){
        AuthUserTokenDto authUserTokenDto = new AuthUserTokenDto();

        authUserTokenDto.setUserId(authUser.getId());
        authUserTokenDto.setEmail(authUser.getEmail());
        authUserTokenDto.setName(authUser.getName());
        authUserTokenDto.setToken(token);

        return authUserTokenDto;
    }

}
