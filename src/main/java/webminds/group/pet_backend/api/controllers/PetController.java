package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.pet.repositories.PetRepository;
import webminds.group.pet_backend.services.pet.PetService;
import webminds.group.pet_backend.services.pet.dto.PetCreationDto;
import webminds.group.pet_backend.services.pet.dto.PetDTO;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> get(){
        List<Pet> pet = this.petService.get();
        if (pet.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(pet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getById(@PathVariable Long id){
        Pet pets = this.petService.getById(id);
        if(pets == null){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(pets);
    }

    @PostMapping
    public ResponseEntity<Pet> create(@RequestBody @Valid PetCreationDto petCreationDto){
        Pet pet = this.petService.create(petCreationDto);
        return ResponseEntity.created(null).body(pet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> upgrade(@RequestBody @Valid PetCreationDto petCreationDto, @PathVariable Long id){
        PetDTO result = this.petService.update(petCreationDto, id);
        if(result == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean result = this.petService.delete(id);
        if(result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
