package webminds.group.pet_backend.services.user.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webminds.group.pet_backend.api.configuration.security.jwt.ManagerTokenJwt;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.domain.user.repositories.AuthUserRepository;
import webminds.group.pet_backend.exception.ConflictCreateException;
import webminds.group.pet_backend.services.user.authentication.dto.AuthUserLoginDto;
import webminds.group.pet_backend.services.user.authentication.dto.AuthUserTokenDto;
import webminds.group.pet_backend.services.user.client.dto.mapper.AuthUserMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final AuthUserRepository authUsuarioRepository;

    private final ManagerTokenJwt managerTokenJwt;

    private final AuthenticationManager authenticationManager;

    public AuthUser createAuthUser(AuthUser authUser) {
        AuthUser newAuthUser = authUser;
        boolean exist = authUsuarioRepository.existsByEmail(newAuthUser.getEmail());

        if(exist){
            throw new ConflictCreateException("authUser", newAuthUser.getEmail());
        }

        String senhaCriptografada = passwordEncoder.encode(newAuthUser.getPassword());
        newAuthUser.setPassword(senhaCriptografada);


        authUsuarioRepository.save(newAuthUser);
        return newAuthUser;
    }

    public AuthUser update(AuthUser authUser, Long id){
        AuthUser newAuthUser = authUser;
        Optional<AuthUser> verificar = getById(id);

        boolean exist = authUsuarioRepository.existsByEmail(newAuthUser.getEmail());

        if(verificar.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        if(exist && !verificar.get().getEmail().equals(newAuthUser.getEmail())){
            throw new ConflictCreateException("authUser", newAuthUser.getEmail());
        }

        String senhaCriptografada = passwordEncoder.encode(newAuthUser.getPassword());
        newAuthUser.setPassword(senhaCriptografada);
        newAuthUser.setId(id);
        authUsuarioRepository.save(newAuthUser);

        return newAuthUser;
    }

    public Optional<AuthUser> getById(Long id){
        return authUsuarioRepository.findById(id);
    }

    public void delete(Long id){
        boolean exist = authUsuarioRepository.existsById(id);
        if(!exist){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        authUsuarioRepository.deleteById(id);

    }



    public List<AuthUser> get(){
        return authUsuarioRepository.findAll();
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
