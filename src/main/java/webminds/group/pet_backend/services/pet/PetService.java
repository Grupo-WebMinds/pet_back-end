package webminds.group.pet_backend.services.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.pet.repositories.PetRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public Pet creationPet(Pet pet){
        return this.petRepository.save(pet);
    }

    public List<Pet> get(){
        return this.petRepository.findAll();
    }

    public Optional<Pet> getById(Long id){
        return this.petRepository.findById(id);
    }

    public Pet update(Pet pet, Long id){
        boolean exist = petRepository.existsById(id);
        if(!exist){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        pet.setId(id);
        return petRepository.save(pet);
    }

    public void delete(Long id){
        boolean exist = petRepository.existsById(id);
        if(!exist){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        petRepository.deleteById(id);

    }

}
