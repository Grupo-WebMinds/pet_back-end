package webminds.group.pet_backend.domain.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webminds.group.pet_backend.domain.pet.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findById(Long id);
}
