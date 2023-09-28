package webminds.group.pet_backend.services.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webminds.group.pet_backend.api.configuration.security.jwt.ManagerTokenJwt;
import webminds.group.pet_backend.domain.client.AuthUser;
import webminds.group.pet_backend.domain.client.repositories.AuthUserRepository;
import webminds.group.pet_backend.services.Client.authentication.dto.AuthUserLoginDto;
import webminds.group.pet_backend.services.Client.authentication.dto.AuthUserTokenDto;
import webminds.group.pet_backend.services.Client.dto.AuthUserCreationDto;
import webminds.group.pet_backend.services.Client.dto.AuthUserMapper;

@Service
public class AuthUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthUserRepository usuarioRepository;

    @Autowired
    private ManagerTokenJwt managerTokenJwt;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void create(AuthUserCreationDto usuarioCriacaoDto) {
        final AuthUser newUser = AuthUserMapper.of(usuarioCriacaoDto);

        String senhaCriptografada = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(senhaCriptografada);

        this.usuarioRepository.save(newUser);
    }

    public AuthUserTokenDto authenticate(AuthUserLoginDto usuarioLoginDto) {

        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                usuarioLoginDto.getEmail(), usuarioLoginDto.getPassword());

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        AuthUser usuarioAutenticado =
                usuarioRepository.findByEmail(usuarioLoginDto.getEmail())
                        .orElseThrow(
                                () -> new ResponseStatusException(404, "Email do usuário não cadastrado", null)
                        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = managerTokenJwt.generateToken(authentication);

        return AuthUserMapper.of(usuarioAutenticado, token);

    }

}
