package webminds.group.pet_backend.domain.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import webminds.group.pet_backend.domain.user.AuthUser;

import java.util.List;
import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    Optional<AuthUser> findByEmail(String email);

    boolean existsByEmail(String email);

}
