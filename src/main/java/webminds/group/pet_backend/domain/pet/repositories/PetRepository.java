package webminds.group.pet_backend.domain.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webminds.group.pet_backend.domain.pet.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
