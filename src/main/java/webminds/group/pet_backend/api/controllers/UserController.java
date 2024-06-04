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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
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

    @GetMapping("/{id}")
    private ResponseEntity<AuthUserDto> getById(@PathVariable Long id){
        Optional<AuthUser> user = this.userService.getById(id);

        if (user.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(AuthUserMapper.ofDto(user.get()));
    }

    @PostMapping
    private ResponseEntity<Void> create(@RequestBody @Valid AuthUserCreationDto newUser){
        userService.createAuthUser(AuthUserMapper.ofCreationDto(newUser));

        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<Void> update(@RequestBody @Valid AuthUserCreationDto newUser, @PathVariable Long id){
        userService.update(AuthUserMapper.ofCreationDto(newUser), id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
