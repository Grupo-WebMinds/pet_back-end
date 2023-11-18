package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.services.pet.PetService;
import webminds.group.pet_backend.services.pet.dto.PetCreationDto;
import webminds.group.pet_backend.services.pet.dto.mapper.PetMapper;
import webminds.group.pet_backend.services.user.client.UserService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {

    private final UserService userService;
    private final PetService petService;

    @PostMapping("/{id}")
    private ResponseEntity<Void> create(@RequestBody @Valid PetCreationDto petCreationDto, @PathVariable Long id){
        Optional<AuthUser> user = this.userService.getById(id);

        if (user.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        this.petService.creationPet(PetMapper.ofCreation(petCreationDto, user.get()));
        return ResponseEntity.created(null).build();
    }

}
