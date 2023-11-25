package webminds.group.pet_backend.services.service.dto.mapper;

import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.service.ServicePet;
import webminds.group.pet_backend.services.petShop.dto.mapper.PetShopMapper;
import webminds.group.pet_backend.services.service.dto.ServiceCreationDto;
import webminds.group.pet_backend.services.service.dto.ServicePetDto;

public class ServicePetMapper {

    public static ServicePet ofCreation(ServiceCreationDto serviceCreationDto, PetShop petShop){
        ServicePet servicePet = new ServicePet();
        servicePet.setName(serviceCreationDto.getName());
        servicePet.setSize(serviceCreationDto.getSize());
        servicePet.setPrice(serviceCreationDto.getPrice());
        servicePet.setPetShop(petShop);


        return servicePet;
    }

    public static ServicePetDto of(ServicePet servicePet){
        ServicePetDto dto = new ServicePetDto();
        dto.setId(servicePet.getId());
        dto.setName(servicePet.getName());
        dto.setSize(servicePet.getSize());
        dto.setPrice(servicePet.getPrice());
        dto.setPetShopDto(PetShopMapper.ofDto(servicePet.getPetShop()));

        return dto;
    }

}
