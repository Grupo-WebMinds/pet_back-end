package webminds.group.pet_backend.services.petShop.dto.mapper;

import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.services.petShop.dto.PetShopCreationDto;
import webminds.group.pet_backend.services.petShop.dto.PetShopDto;

public class PetShopMapper {

   public static PetShop ofCreation(PetShopCreationDto petShopDto, AuthUser user){
       PetShop pet = new PetShop();

       pet.setNome(petShopDto.getNome());
       pet.setCnpj(petShopDto.getCnpj());
       pet.setCep(petShopDto.getCep());
       pet.setLogradouro(petShopDto.getLogradouro());
       pet.setComplemento(petShopDto.getComplemento());
       pet.setLocalidade(petShopDto.getLocalidade());
       pet.setBairro(petShopDto.getBairro());
       pet.setUf(petShopDto.getUf());
       pet.setAuthUser(user);

       return pet;
   }

   public static PetShopDto ofDto(PetShop petShop){
       PetShopDto pet = new PetShopDto();
       pet.setId(petShop.getId());
       pet.setNome(petShop.getNome());
       pet.setCnpj(petShop.getCnpj());
       pet.setCep(petShop.getCep());
       pet.setLogradouro(petShop.getLogradouro());
       pet.setComplemento(petShop.getComplemento());
       pet.setLocalidade(petShop.getLocalidade());
       pet.setBairro(petShop.getBairro());
       pet.setUf(petShop.getUf());

       return pet;
   }


}
