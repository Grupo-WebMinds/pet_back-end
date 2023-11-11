package webminds.group.pet_backend.services.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webminds.group.pet_backend.api.configuration.security.jwt.ManagerTokenJwt;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.domain.user.User;
import webminds.group.pet_backend.domain.user.repositories.AuthUserRepository;
import webminds.group.pet_backend.domain.user.repositories.UserRepository;
import webminds.group.pet_backend.services.user.authentication.dto.AuthUserLoginDto;
import webminds.group.pet_backend.services.user.authentication.dto.AuthUserTokenDto;
import webminds.group.pet_backend.services.user.dto.AuthUserCreationDto;
import webminds.group.pet_backend.services.user.dto.AuthUserMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final AuthUserRepository authUsuarioRepository;

    private final UserRepository userRepository;

    private final ManagerTokenJwt managerTokenJwt;

    private final AuthenticationManager authenticationManager;

    public AuthUser createAuthUser(AuthUser authUser) {
        AuthUser newAuthUser = authUser;
        String senhaCriptografada = passwordEncoder.encode(newAuthUser.getPassword());
        newAuthUser.setPassword(senhaCriptografada);
        authUsuarioRepository.save(newAuthUser);
        return newAuthUser;
    }

    public User getByIdUser(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public AuthUser getByIdAuthUser(Long id){
        Optional<AuthUser> user = authUsuarioRepository.findById(id);
        return user.get();
    }

    public User createUser(User user){
        User newUser = userRepository.save(user);
        return newUser;
    }

    public AuthUserTokenDto authenticate(AuthUserLoginDto usuarioLoginDto) {

        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                usuarioLoginDto.getEmail(), usuarioLoginDto.getPassword());

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        AuthUser usuarioAutenticado =
                authUsuarioRepository.findByEmail(usuarioLoginDto.getEmail())
                        .orElseThrow(
                                () -> new ResponseStatusException(404, "Email do usuário não cadastrado", null)
                        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = managerTokenJwt.generateToken(authentication);

        return AuthUserMapper.of(usuarioAutenticado, token);

    }

}
