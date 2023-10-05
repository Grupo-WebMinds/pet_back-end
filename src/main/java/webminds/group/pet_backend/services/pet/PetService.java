package webminds.group.pet_backend.services.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.pet.repositories.PetRepository;
import webminds.group.pet_backend.exception.UserNotFound;
import webminds.group.pet_backend.services.pet.dto.PetCreationDto;
import webminds.group.pet_backend.services.pet.dto.PetDTO;
import webminds.group.pet_backend.services.pet.dto.PetMapper;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet create(PetCreationDto petCreationDto) {
        final Pet newPet = PetMapper.of(petCreationDto);

        return this.petRepository.save(newPet);
    }
    public List<Pet> get(){
        List<Pet> pets = this.petRepository.findAll();
        if (pets.isEmpty()){
            return null;
        }
        return pets;
    }

    public Pet getById(Long id) {

        return this.petRepository.findById(id).
                orElseThrow(() -> new UserNotFound("User", id));
    }

    public boolean delete(Long id){
        boolean exist = this.petRepository.existsById(id);
        if(exist){
            this.petRepository.deleteById(id);
        }
            return exist;
    }

    public PetDTO update(PetCreationDto petCreationDto, Long id){
        boolean exist = this.petRepository.existsById(id);
        if (exist){
            Pet pet = PetMapper.of(petCreationDto);
            pet.setId(id);
            petRepository.save(pet);
            return PetMapper.ofDTO(pet);
        }
        return null;

    }

}
