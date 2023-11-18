package webminds.group.pet_backend.domain.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webminds.group.pet_backend.domain.service.ServicePet;

public interface ServicePetRepository extends JpaRepository<ServicePet, Long> {
}
