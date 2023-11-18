package webminds.group.pet_backend.services.closed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webminds.group.pet_backend.domain.closed.ClosedDaysPetShop;
import webminds.group.pet_backend.domain.closed.ClosedWeekPetShop;
import webminds.group.pet_backend.domain.closed.repositories.ClosedDaysPetShopRepository;
import webminds.group.pet_backend.domain.closed.repositories.ClosedWeekPetShopRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ClosedService {

    private final ClosedDaysPetShopRepository closedDaysPetShopRepository;
    private final ClosedWeekPetShopRepository closedWeekPetShopRepository;

    public boolean existDaysPetShop(Long id,LocalDate date){
        return closedDaysPetShopRepository.existsByPetShopIdAndDateClose(id ,date);
    }

    public boolean existWeekPetShop(Long id, Short week){
        return closedWeekPetShopRepository.existsByPetShopIdAndIsClosed(id, week);
    }

    public ClosedDaysPetShop creationDaysPetShop(ClosedDaysPetShop closedDaysPetShop){
        return closedDaysPetShopRepository.save(closedDaysPetShop);
    }

    public ClosedWeekPetShop creationWeekPetShop(ClosedWeekPetShop closedWeekPetShop){
        return closedWeekPetShopRepository.save(closedWeekPetShop);
    }

}
