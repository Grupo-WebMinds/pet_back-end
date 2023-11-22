package webminds.group.pet_backend.services.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.pet.repositories.PetRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public Pet creationPet(Pet pet){
        return this.petRepository.save(pet);
    }

    public Optional<Pet> getById(Long id){
        return this.petRepository.findById(id);
    }

}
