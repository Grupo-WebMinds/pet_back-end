package webminds.group.pet_backend.services.closed.dto.mapper;

import webminds.group.pet_backend.domain.closed.ClosedDaysPetShop;
import webminds.group.pet_backend.domain.closed.ClosedWeekPetShop;
import webminds.group.pet_backend.domain.petShop.PetShop;

import java.time.LocalDate;

public class ClosedPetShopMapper {

    public static ClosedDaysPetShop ofCreationDays(LocalDate date, PetShop petShop){
        ClosedDaysPetShop dto = new ClosedDaysPetShop();
        dto.setDateClose(date);
        dto.setPetShop(petShop);
        return dto;
    }

    public static ClosedWeekPetShop ofCreationWeek(Short week, PetShop petShop){
        ClosedWeekPetShop dto = new ClosedWeekPetShop();
        dto.setIsClosed(week);
        dto.setPetShop(petShop);

        return dto;
    }

}
