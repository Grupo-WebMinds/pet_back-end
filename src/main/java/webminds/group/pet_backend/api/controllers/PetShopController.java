package webminds.group.pet_backend.api.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.services.petShop.PetShopService;
import webminds.group.pet_backend.services.petShop.dto.PetShopCreationDto;
import webminds.group.pet_backend.services.petShop.dto.PetShopDto;
import webminds.group.pet_backend.services.petShop.dto.mapper.PetShopMapper;
import webminds.group.pet_backend.services.user.client.UserService;
import webminds.group.pet_backend.services.user.client.dto.mapper.AuthUserMapper;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/pet-shop")
public class PetShopController {

    private final PetShopService petShopService;
    private final UserService userService;


    @GetMapping
    private ResponseEntity<List<PetShopDto>> get() {
        List<PetShop> all = petShopService.get();

        if (all.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all.stream().map(PetShopMapper::ofDto).toList());
    }

    @GetMapping("/{id}")
    private ResponseEntity<PetShopDto> getById(@PathVariable Long id){
        Optional<PetShop> item = petShopService.getById(id);

        if (item.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(PetShopMapper.ofDto(item.get()));
    }


    @PostMapping("/{idOwner}")
    public ResponseEntity<Void> create(@RequestBody @Valid PetShopCreationDto petShopCreationDto, @PathVariable Long idOwner){

        Optional<AuthUser> user = this.userService.getById(idOwner);

        if (user.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        Optional<PetShop> petShop = this.petShopService.getByUser(idOwner);

        if (petShop.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        this.petShopService.create(PetShopMapper.ofCreation(petShopCreationDto, user.get()));

        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        petShopService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
