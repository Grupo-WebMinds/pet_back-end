package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.services.petShop.PetShopService;
import webminds.group.pet_backend.services.petShop.dto.PetShopCreationDto;
import webminds.group.pet_backend.services.petShop.dto.PetShopDto;

import java.util.List;

@RestController
@RequestMapping("/pets-shops")
public class PetShopController {

    @Autowired
    private PetShopService petShopService;

    @PostMapping
    public ResponseEntity<PetShopDto> create(@RequestBody @Valid PetShopCreationDto petShopCreationDto){
        PetShopDto petShopDto = this.petShopService.create(petShopCreationDto);
        return ResponseEntity.created(null).body(petShopDto);
    }

    @GetMapping
    public ResponseEntity<List<PetShopDto>> get(){
        List<PetShopDto> petShopDtos = this.petShopService.get();
        if (petShopDtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(petShopDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetShopDto> getById(@PathVariable Long id) {
        PetShopDto petShopDto = this.petShopService.getById(id);
        if (petShopDto == null){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(petShopDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PetShopDto> upgrade(@RequestBody @Valid PetShopCreationDto petShopCreationDto, @PathVariable Long id){
        PetShopDto result = this.petShopService.update(petShopCreationDto, id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = this.petShopService.delete(id);
        if (result) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
