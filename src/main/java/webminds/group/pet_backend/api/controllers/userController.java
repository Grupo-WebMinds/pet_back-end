package webminds.group.pet_backend.api.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.domain.user.User;
import webminds.group.pet_backend.services.user.UserService;
import webminds.group.pet_backend.services.user.authentication.dto.AuthUserLoginDto;
import webminds.group.pet_backend.services.user.authentication.dto.AuthUserTokenDto;
import webminds.group.pet_backend.services.user.dto.AuthUserAndUserCreationDto;
import webminds.group.pet_backend.services.user.dto.AuthUserCreationDto;
import webminds.group.pet_backend.services.user.dto.AuthUserDto;
import webminds.group.pet_backend.services.user.dto.AuthUserMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class userController {

    private final UserService userService;

    @PostMapping
    private ResponseEntity<AuthUserDto> create(@RequestBody @Valid AuthUserAndUserCreationDto newUser){
        AuthUser authUser = userService.createAuthUser(AuthUserMapper.ofCreationAuth(newUser));
        User userId = userService.createUser(AuthUserMapper.ofCreationUser(newUser, authUser));
        AuthUser authUserBusc = userService.getByIdAuthUser(authUser.getId());
        User userBusc = userService.getByIdUser(userId.getId());
        AuthUserDto userDto = AuthUserMapper.toAuth(authUserBusc, userBusc);

        return ResponseEntity.created(null).body(userDto);
    }

}
