package webminds.group.pet_backend.domain.closed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webminds.group.pet_backend.domain.closed.ClosedDaysPetShop;

import java.time.LocalDate;

public interface ClosedDaysPetShopRepository extends JpaRepository<ClosedDaysPetShop, Long> {

    boolean existsByPetShopIdAndDateClose(Long id ,LocalDate date);

}
