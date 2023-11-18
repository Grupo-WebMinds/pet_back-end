package webminds.group.pet_backend.services.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webminds.group.pet_backend.domain.service.ServicePet;
import webminds.group.pet_backend.domain.service.repositories.ServicePetRepository;

@Service
@RequiredArgsConstructor
public class ServicePetService {

    private final ServicePetRepository servicePetRepository;

    public ServicePet create(ServicePet service) {
        return servicePetRepository.save(service);
    }

}

