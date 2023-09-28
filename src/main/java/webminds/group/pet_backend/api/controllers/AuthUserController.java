package webminds.group.pet_backend.api.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webminds.group.pet_backend.services.Client.AuthUserService;
import webminds.group.pet_backend.services.Client.authentication.dto.AuthUserLoginDto;
import webminds.group.pet_backend.services.Client.authentication.dto.AuthUserTokenDto;
import webminds.group.pet_backend.services.Client.dto.AuthUserCreationDto;

@RestController
@RequestMapping("/usuarios")
public class AuthUserController {

    @Autowired
    private AuthUserService authUserService;

    @PostMapping
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Void> criar(@RequestBody @Valid AuthUserCreationDto authUserCreationDto) {
        this.authUserService.create(authUserCreationDto);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthUserTokenDto> login(@RequestBody AuthUserLoginDto authUserLoginDto) {
        AuthUserTokenDto authUserTokenDto = this.authUserService.authenticate(authUserLoginDto);

        return ResponseEntity.status(200).body(authUserTokenDto);
    }


}
