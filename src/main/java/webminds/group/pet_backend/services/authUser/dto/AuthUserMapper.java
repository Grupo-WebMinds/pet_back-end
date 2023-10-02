package webminds.group.pet_backend.services.authUser.dto;

import webminds.group.pet_backend.domain.authUser.AuthUser;
import webminds.group.pet_backend.services.authUser.authentication.dto.AuthUserTokenDto;

public class AuthUserMapper {

    public static AuthUser of(AuthUserCreationDto authUserCreationDto){
        AuthUser authUser = new AuthUser();

        authUser.setEmail(authUserCreationDto.getEmail());
        authUser.setName(authUserCreationDto.getName());
        authUser.setPassword(authUserCreationDto.getPassword());
        authUser.setUserType(authUserCreationDto.getUserType());

        return authUser;
    }

    public static AuthUserTokenDto of(AuthUser authUser, String token){
        AuthUserTokenDto authUserTokenDto = new AuthUserTokenDto();

        authUserTokenDto.setUserId(authUser.getId());
        authUserTokenDto.setEmail(authUser.getEmail());
        authUserTokenDto.setName(authUser.getName());
        authUserTokenDto.setUserType(authUser.getUserType());
        authUserTokenDto.setToken(token);

        return authUserTokenDto;
    }

}
