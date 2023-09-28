package webminds.group.pet_backend.api.configuration.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import webminds.group.pet_backend.services.Client.authentication.AuthenticationUserService;

public class AuthenticationUserProvider implements AuthenticationProvider {

    private final AuthenticationUserService authenticationUserService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationUserProvider(AuthenticationUserService authenticationUserService, PasswordEncoder passwordEncoder) {
        this.authenticationUserService = authenticationUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();

        UserDetails userDetails = this.authenticationUserService.loadUserByUsername(username);

        if(this.passwordEncoder.matches(password, userDetails.getPassword())){
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        }else{
            throw new BadCredentialsException("Usuário ou senha inválidos");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
