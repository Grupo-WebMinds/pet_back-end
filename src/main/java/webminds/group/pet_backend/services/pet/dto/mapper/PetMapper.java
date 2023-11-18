package webminds.group.pet_backend.services.pet.dto.mapper;


import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.services.pet.dto.PetCreationDto;

import java.time.LocalDateTime;

public class PetMapper {

    public static Pet ofCreation(PetCreationDto petCreationDto, AuthUser authUser){
        Pet pet = new Pet();

        pet.setName(petCreationDto.getName());
        pet.setTypePet(petCreationDto.getTypePet());
        pet.setRace(petCreationDto.getRace());
        pet.setWeight(petCreationDto.getWeight());
        pet.setSize(petCreationDto.getSize());
        pet.setGender(petCreationDto.getGender());
        pet.setDateBirth(petCreationDto.getDateBirth());
        pet.setDateCreation(LocalDateTime.now());
        pet.setAuthUser(authUser);

        return pet;
    }

}
