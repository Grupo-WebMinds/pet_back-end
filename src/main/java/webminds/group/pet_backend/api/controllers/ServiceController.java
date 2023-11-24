package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.service.ServicePet;
import webminds.group.pet_backend.services.petShop.PetShopService;
import webminds.group.pet_backend.services.service.ServicePetService;
import webminds.group.pet_backend.services.service.dto.ServiceCreationDto;
import webminds.group.pet_backend.services.service.dto.ServicePetDto;
import webminds.group.pet_backend.services.service.dto.mapper.ServicePetMapper;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/servicos")
public class ServiceController {

    private final PetShopService petShopService;
    private final ServicePetService servicePet;

    @GetMapping
    private ResponseEntity<List<ServicePetDto>> get() {
        List<ServicePet> all = servicePet.get();

        if (all.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all.stream().map(ServicePetMapper::of).toList());
    }

    @GetMapping("/{id}")
    private ResponseEntity<ServicePetDto> getById(@PathVariable Long id){
        Optional<ServicePet> item = servicePet.getById(id);

        if (item.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(ServicePetMapper.of(item.get()));
    }


    @PostMapping("/{idOwner}")
    private ResponseEntity<Void> create(@RequestBody @Valid ServiceCreationDto serviceCreationDto, @PathVariable Long idOwner){

        Optional<PetShop> petShop = this.petShopService.getByUser(idOwner);

        if (petShop.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        this.servicePet.create(ServicePetMapper.ofCreation(serviceCreationDto, petShop.get()));


        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{idOwner}/{id}")
    private ResponseEntity<Void> update(@RequestBody @Valid ServiceCreationDto serviceCreationDto, @PathVariable Long idOwner, @PathVariable Long id){

        Optional<PetShop> petShop = this.petShopService.getByUser(idOwner);

        if (petShop.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        this.servicePet.update(ServicePetMapper.ofCreation(serviceCreationDto, petShop.get()), id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        servicePet.delete(id);
        return ResponseEntity.noContent().build();
    }

}
