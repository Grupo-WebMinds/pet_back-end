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
import webminds.group.pet_backend.services.pet.listPet.ListaPet;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public PetDTO create(PetCreationDto petCreationDto) {
        final Pet newPet = PetMapper.of(petCreationDto);

        return PetMapper.ofDTO(this.petRepository.save(newPet));
    }
    public List<PetDTO> get(){
        List<Pet> pets = this.petRepository.findAll();
        if (pets.isEmpty()){
            return null;
        }
        List<PetDTO> petsDTO = pets.stream().map(PetMapper::ofDTO).toList();

        ListaPet listaPet = new ListaPet();
        listaPet.TamanhoArq(petsDTO.size());

        listaPet.adicionar(petsDTO);
        listaPet.bubbleSort();
        listaPet.GravaArquivoCsv("pet");

        return petsDTO;
    }

    public PetDTO getById(Long id) {
        Optional<Pet> petOpt = this.petRepository.findById(id);

        if(petOpt.isEmpty()){
            return null;
        }

        Pet petBanco = petOpt.get();
        return PetMapper.ofDTO(petBanco);
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
