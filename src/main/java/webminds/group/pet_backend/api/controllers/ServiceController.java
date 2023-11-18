package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.services.petShop.PetShopService;
import webminds.group.pet_backend.services.service.ServicePetService;
import webminds.group.pet_backend.services.service.dto.ServiceCreationDto;
import webminds.group.pet_backend.services.service.dto.mapper.ServicePetMapper;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/services")
public class ServiceController {

    private final PetShopService petShopService;
    private final ServicePetService servicePet;

    @PostMapping("/{id}")
    private ResponseEntity<Void> create(@RequestBody @Valid ServiceCreationDto serviceCreationDto, @PathVariable Long id){

        Optional<PetShop> petShop = this.petShopService.getByUser(id);

        if (petShop.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        this.servicePet.create(ServicePetMapper.ofCreation(serviceCreationDto, petShop.get()));


        return ResponseEntity.created(null).build();
    }

}
