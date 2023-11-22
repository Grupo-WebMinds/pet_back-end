package webminds.group.pet_backend.services.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webminds.group.pet_backend.services.petShop.dto.PetShopDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicePetDto {

    private String name;
    private Short size;
    private Double price;
    private PetShopDto petShopDto;

}
