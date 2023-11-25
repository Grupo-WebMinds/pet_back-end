package webminds.group.pet_backend.domain.scheduling.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webminds.group.pet_backend.domain.scheduling.Scheduling;

import java.util.List;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {

    List<Scheduling> findAllByPetAuthUserId(Long id);

}
