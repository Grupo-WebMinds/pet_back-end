package webminds.group.pet_backend.api.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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


    @PostMapping("/{id}")
    public ResponseEntity<Void> create(@RequestBody @Valid PetShopCreationDto petShopCreationDto, @PathVariable Long id){

        Optional<AuthUser> user = this.userService.getById(id);

        if (user.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        this.petShopService.create(PetShopMapper.ofCreation(petShopCreationDto, user.get()));

        return ResponseEntity.created(null).build();
    }


}
