package webminds.group.pet_backend.services.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.pet.repositories.PetRepository;
import webminds.group.pet_backend.services.pet.dto.PetCreationDto;
import webminds.group.pet_backend.services.pet.dto.PetDto;
import webminds.group.pet_backend.services.pet.dto.PetMapper;
import webminds.group.pet_backend.services.pet.listPet.ListaPet;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public PetDto create(PetCreationDto petCreationDto) {
        final Pet newPet = PetMapper.of(petCreationDto);

        return PetMapper.ofDTO(this.petRepository.save(newPet));
    }
    public List<PetDto> get(){
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

    public PetDto getById(Long id) {
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

    public PetDto update(PetCreationDto petCreationDto, Long id){
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
