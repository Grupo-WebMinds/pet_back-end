package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.services.closed.ClosedService;
import webminds.group.pet_backend.services.closed.dto.ClosedPetShopCreationDto;
import webminds.group.pet_backend.services.closed.dto.mapper.ClosedPetShopMapper;
import webminds.group.pet_backend.services.petShop.PetShopService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/closed")
public class ClosedController {

    private final PetShopService petShopService;
    private final ClosedService closedService;

    @PostMapping("/pet-shop/{id}")
    public ResponseEntity<Object> createClosedPetShop(@RequestBody @Valid ClosedPetShopCreationDto closedDto,  @PathVariable Long id){

        Optional<PetShop> petShop = this.petShopService.getByUser(id);

        if (petShop.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        List<LocalDate> closedDates = closedDto.getDays();

        for (LocalDate date : closedDates){
            boolean exist = closedService.existDaysPetShop(petShop.get().getId(),date);
            if(exist){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Alguma data já está cadastrada");
            }
        }

        List<Short> closedWeek = closedDto.getWeek();

        for (Short week : closedWeek){
            boolean exist = closedService.existWeekPetShop(petShop.get().getId(), week);
            if(exist){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Algum dia da Semana já está cadastrada");
            }
        }

        closedDates.stream().map(days -> closedService.creationDaysPetShop(ClosedPetShopMapper.ofCreationDays(days, petShop.get()))).toList();
        closedWeek.stream().map(week -> closedService.creationWeekPetShop(ClosedPetShopMapper.ofCreationWeek(week, petShop.get()))).toList();



        return ResponseEntity.created(null).build();

    }

}
