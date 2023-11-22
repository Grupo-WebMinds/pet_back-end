package webminds.group.pet_backend.services.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webminds.group.pet_backend.domain.service.ServicePet;
import webminds.group.pet_backend.domain.service.repositories.ServicePetRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicePetService {

    private final ServicePetRepository servicePetRepository;

    public ServicePet create(ServicePet service) {
        return servicePetRepository.save(service);
    }

    public Optional<ServicePet> getById(Long id){
        return servicePetRepository.findById(id);
    }

}

