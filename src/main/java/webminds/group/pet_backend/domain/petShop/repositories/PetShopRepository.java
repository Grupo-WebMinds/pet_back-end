package webminds.group.pet_backend.domain.petShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webminds.group.pet_backend.domain.petShop.PetShop;

import java.util.Optional;

public interface PetShopRepository extends JpaRepository<PetShop, Long> {

    Optional<PetShop> findByAuthUserId(Long id);

    boolean existsByCnpj(String cnpj);

}
