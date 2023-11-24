package webminds.group.pet_backend.services.user.client.dto.mapper;

import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.services.user.authentication.dto.AuthUserTokenDto;
import webminds.group.pet_backend.services.user.client.dto.AuthUserCreationDto;
import webminds.group.pet_backend.services.user.client.dto.AuthUserDto;

import java.time.LocalDateTime;

public class AuthUserMapper {

    public static AuthUserTokenDto of(AuthUser authUser, String token){
        AuthUserTokenDto authUserTokenDto = new AuthUserTokenDto();

        authUserTokenDto.setUserId(authUser.getId());
        authUserTokenDto.setEmail(authUser.getEmail());
        authUserTokenDto.setUserType(authUser.getUserType());
        authUserTokenDto.setToken(token);

        return authUserTokenDto;
    }

    public static AuthUserDto ofDto(AuthUser authUser){
        AuthUserDto dto = new AuthUserDto();

        dto.setName(authUser.getName());
        dto.setEmail(authUser.getEmail());
        dto.setCpf(authUser.getCpf());
        dto.setUserType(authUser.getUserType());
        dto.setCellPhone(authUser.getCellPhone());
        dto.setTelephone(authUser.getTelephone());
        dto.setDateBirth(authUser.getDateBirth());
        dto.setGender(authUser.getGender());
        dto.setDateCreation(authUser.getDateCreation());

        return dto;
    }

    public static AuthUser ofCreationDto(AuthUserCreationDto authUser){
        AuthUser dto = new AuthUser();

        dto.setName(authUser.getName());
        dto.setPassword(authUser.getPassword());
        dto.setEmail(authUser.getEmail());
        dto.setCpf(authUser.getCpf());
        dto.setUserType(authUser.getUserType());
        dto.setCellPhone(authUser.getCellPhone());
        dto.setTelephone(authUser.getTelephone());
        dto.setDateBirth(authUser.getDateBirth());
        dto.setGender(authUser.getGender());
        dto.setDateCreation(LocalDateTime.now());

        return dto;
    }
}
