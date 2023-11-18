package webminds.group.pet_backend.services.service.dto.mapper;

import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.service.ServicePet;
import webminds.group.pet_backend.services.service.dto.ServiceCreationDto;

public class ServicePetMapper {

    public static ServicePet ofCreation(ServiceCreationDto serviceCreationDto, PetShop petShop){
        ServicePet servicePet = new ServicePet();
        servicePet.setName(serviceCreationDto.getName());
        servicePet.setSize(serviceCreationDto.getSize());
        servicePet.setPrice(serviceCreationDto.getPrice());
        servicePet.setPetShop(petShop);


        return servicePet;
    }

}
