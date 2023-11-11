package webminds.group.pet_backend.services.user.dto;

import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.domain.user.User;
import webminds.group.pet_backend.services.user.authentication.dto.AuthUserTokenDto;

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

    public static AuthUser ofCreationAuth(AuthUserAndUserCreationDto newUser){
        AuthUser user = new AuthUser();
        user.setEmail(newUser.getEmail());
        user.setUserType(newUser.getUserType());
        user.setPassword(newUser.getPassword());

        return user;
    }

    public static User ofCreationUser(AuthUserAndUserCreationDto newUser, AuthUser authUser){
        User user = new User();
        user.setName(newUser.getName());
        user.setCellPhone(newUser.getCellPhone());
        user.setTelephone(newUser.getTelephone());
        user.setDateBirth(newUser.getDateBirth());
        user.setCpf(newUser.getCpf());
        user.setDateCreation(LocalDateTime.now());
        user.setAuthUser(authUser);

        return user;
    }

    public static AuthUserDto toAuth(AuthUser authUser, User user){
        AuthUserDto userDto = new AuthUserDto();
        userDto.setEmail(authUser.getEmail());
        userDto.setUserType(authUser.getUserType());
        userDto.setUser(toUser(user));
        return userDto;
    }

    public static UserResponseDto toUser(User newUser){
        UserResponseDto user = new UserResponseDto();

        user.setName(newUser.getName());
        user.setCellPhone(newUser.getCellPhone());
        user.setTelephone(newUser.getTelephone());
        user.setDateBirth(newUser.getDateBirth());
        user.setCpf(newUser.getCpf());
        user.setDateCreation(newUser.getDateCreation());

        return user;
    }

}
