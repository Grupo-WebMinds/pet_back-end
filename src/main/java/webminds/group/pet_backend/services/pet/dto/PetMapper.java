package webminds.group.pet_backend.services.pet.dto;


import webminds.group.pet_backend.domain.pet.Pet;

import java.util.List;

public class PetMapper {

    public static Pet of(PetCreationDto petCreationDto){
        Pet pet = new Pet();

        pet.setName(petCreationDto.getName());
        pet.setBirthDate(petCreationDto.getBirthDate());
        pet.setSize(petCreationDto.getSize());
        pet.setGender(petCreationDto.getGender());

        return pet;
    }

    public static PetDTO ofDTO(Pet petBanco){
        PetDTO petDTO = new PetDTO();

        petDTO.setId(petBanco.getId());
        petDTO.setName(petBanco.getName());
        petDTO.setGender(petBanco.getGender());
        petDTO.setBirthDate(petBanco.getBirthDate());
        petDTO.setSize(petBanco.getSize());

        return petDTO;
    }
}
