package webminds.group.pet_backend.domain.scheduling.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webminds.group.pet_backend.domain.scheduling.Scheduling;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
}
