package webminds.group.pet_backend.services.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.services.petShop.dto.PetShopDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCreationDto {

    private String name;
    private Short size;
    private Double price;
    private Short typeService;


}
