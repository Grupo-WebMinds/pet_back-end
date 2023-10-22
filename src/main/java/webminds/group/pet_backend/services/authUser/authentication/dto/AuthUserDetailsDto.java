package webminds.group.pet_backend.services.authUser.authentication.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import webminds.group.pet_backend.domain.authUser.AuthUser;

import java.util.Collection;

public class AuthUserDetailsDto implements UserDetails {

    private final String name;
    private final String email;
    private final String password;
    private final Short userType;


    public AuthUserDetailsDto(AuthUser authUser){
        this.name = authUser.getName();
        this.email = authUser.getEmail();
        this.password = authUser.getPassword();
        this.userType = authUser.getUserType();
    }

    public String getName() {
        return name;
    }

    public Short getUserType() {
        return userType;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
