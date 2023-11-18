package webminds.group.pet_backend.services.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.pet.repositories.PetRepository;


@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public Pet creationPet(Pet pet){
        return this.petRepository.save(pet);
    }

}
