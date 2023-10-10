package webminds.group.pet_backend.domain.petShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webminds.group.pet_backend.domain.petShop.PetShop;

public interface PetShopRepository extends JpaRepository<PetShop, Long> {
}
