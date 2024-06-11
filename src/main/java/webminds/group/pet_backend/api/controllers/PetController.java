package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.domain.user.Employee;
import webminds.group.pet_backend.services.pet.PetService;
import webminds.group.pet_backend.services.pet.dto.PetCreationDto;
import webminds.group.pet_backend.services.pet.dto.PetDto;
import webminds.group.pet_backend.services.pet.dto.mapper.PetMapper;
import webminds.group.pet_backend.services.user.client.UserService;
import webminds.group.pet_backend.services.user.employee.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pets")
public class PetController {

    private final UserService userService;
    private final PetService petService;

    @GetMapping
    private ResponseEntity<List<PetDto>> get() {
        List<Pet> all = petService.get();

        if (all.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all.stream().map(PetMapper::of).toList());
    }

    @GetMapping("/user/{id}")
    private ResponseEntity<List<PetDto>> getByUser(@PathVariable Long id) {

        Optional<AuthUser> user = this.userService.getById(id);

        if (user.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        List<Pet> all = petService.getByUser(id);

        if (all.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all.stream().map(PetMapper::of).toList());
    }

    @GetMapping("/{id}")
    private ResponseEntity<PetDto> getById(@PathVariable Long id){
        Optional<Pet> item = petService.getById(id);

        if (item.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(PetMapper.of(item.get()));
    }

    @PostMapping("/{idClient}")
    private ResponseEntity<Void> create(@RequestBody @Valid PetCreationDto petCreationDto, @PathVariable Long idClient){
        Optional<AuthUser> user = this.userService.getById(idClient);

        if (user.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        this.petService.creationPet(PetMapper.ofCreation(petCreationDto, user.get()));
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{idClient}/{id}")
    private ResponseEntity<Void> update(@RequestBody @Valid PetCreationDto petCreationDto, @PathVariable Long idClient, @PathVariable Long id){
        Optional<AuthUser> user = this.userService.getById(idClient);

        if (user.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        this.petService.update(PetMapper.ofCreation(petCreationDto, user.get()), id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        petService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
