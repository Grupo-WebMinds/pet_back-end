package webminds.group.pet_backend.services.pet.dto.mapper;


import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.services.pet.dto.PetCreationDto;
import webminds.group.pet_backend.services.pet.dto.PetDto;
import webminds.group.pet_backend.services.user.client.dto.mapper.AuthUserMapper;

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

    public static PetDto of(Pet pet){
        PetDto dto = new PetDto();
        dto.setId(pet.getId());
        dto.setName(pet.getName());
        dto.setTypePet(pet.getTypePet());
        dto.setRace(pet.getRace());
        dto.setWeight(pet.getWeight());
        dto.setSize(pet.getSize());
        dto.setGender(pet.getGender());
        dto.setDateBirth(pet.getDateBirth());
        dto.setDateCreation(pet.getDateCreation());
        dto.setAuthUserDto(AuthUserMapper.ofDto(pet.getAuthUser()));

        return dto;
    }

}
