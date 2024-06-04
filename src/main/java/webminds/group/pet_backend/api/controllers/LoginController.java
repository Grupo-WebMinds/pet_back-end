package webminds.group.pet_backend.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webminds.group.pet_backend.services.user.client.UserService;
import webminds.group.pet_backend.services.user.authentication.dto.AuthUserLoginDto;
import webminds.group.pet_backend.services.user.authentication.dto.AuthUserTokenDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<AuthUserTokenDto> login(@RequestBody AuthUserLoginDto authUserLoginDto) {
        AuthUserTokenDto authUserTokenDto = this.userService.authenticate(authUserLoginDto);

        return ResponseEntity.status(200).body(authUserTokenDto);
    }

}
