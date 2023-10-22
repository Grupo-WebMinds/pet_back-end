package webminds.group.pet_backend.services.petShop.dto;

import webminds.group.pet_backend.domain.petShop.PetShop;

public class PetShopMapper {

    public static PetShop of(PetShopCreationDto petShopCreationDto){
        PetShop petShop =  new PetShop();

        petShop.setName(petShopCreationDto.getName());
        petShop.setCnpj(petShopCreationDto.getCnpj());
        petShop.setAddress(petShopCreationDto.getAddress());
        petShop.setZipCode(petShopCreationDto.getZipCode());
        petShop.setNumber(petShopCreationDto.getNumber());
        petShop.setComplement(petShopCreationDto.getComplement());
        petShop.setCity(petShopCreationDto.getCity());
        petShop.setState(petShopCreationDto.getState());

        return petShop;
    }

    public static PetShopDto ofDto(PetShop petShop){
        PetShopDto petShopDto = new PetShopDto();

        petShopDto.setId(petShop.getId());
        petShopDto.setName(petShop.getName());
        petShopDto.setCnpj(petShop.getCnpj());
        petShopDto.setAddress(petShop.getAddress());
        petShopDto.setZipCode(petShop.getZipCode());
        petShopDto.setNumber(petShop.getNumber());
        petShopDto.setComplement(petShop.getComplement());
        petShopDto.setCity(petShop.getCity());
        petShopDto.setState(petShop.getState());

        return petShopDto;
    }

}
