package webminds.group.pet_backend.services.authUser.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import webminds.group.pet_backend.domain.authUser.AuthUser;
import webminds.group.pet_backend.domain.authUser.repositories.AuthUserRepository;
import webminds.group.pet_backend.services.authUser.authentication.dto.AuthUserDetailsDto;

import java.util.Optional;

@Service
public class AuthenticationUserService implements UserDetailsService {

    @Autowired
    private AuthUserRepository authUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AuthUser> usuarioOpt = authUserRepository.findByEmail(username);

        if(usuarioOpt.isEmpty()){
            throw new UsernameNotFoundException(String.format("usuario: %s nao encontrado", username));
        }

        return new AuthUserDetailsDto(usuarioOpt.get());
    }
}
