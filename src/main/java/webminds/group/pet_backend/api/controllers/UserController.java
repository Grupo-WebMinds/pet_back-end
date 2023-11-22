package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.services.user.client.UserService;
import webminds.group.pet_backend.services.user.client.dto.AuthUserCreationDto;
import webminds.group.pet_backend.services.user.client.dto.AuthUserDto;
import webminds.group.pet_backend.services.user.client.dto.mapper.AuthUserMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UserController {

    private final UserService userService;

    @GetMapping
    private ResponseEntity<List<AuthUserDto>> get(){
        List<AuthUser> all = this.userService.get();
        if (all.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all.stream().map(AuthUserMapper::ofDto).toList());
    }

    @PostMapping
    private ResponseEntity<Void> create(@RequestBody @Valid AuthUserCreationDto newUser){
        userService.createAuthUser(AuthUserMapper.ofCreationDto(newUser));

        return ResponseEntity.created(null).build();
    }

}
