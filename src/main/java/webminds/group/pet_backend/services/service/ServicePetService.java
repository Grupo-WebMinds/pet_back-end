package webminds.group.pet_backend.services.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webminds.group.pet_backend.domain.service.ServicePet;
import webminds.group.pet_backend.domain.service.repositories.ServicePetRepository;

import java.util.List;
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

    public List<ServicePet> getByPetShop(Long id, Short size){
        return servicePetRepository.findBySizeAndPetShopId(size, id);
    }

    public List<ServicePet> get(){
        return servicePetRepository.findAll();
    }

    public void delete(Long id){
        boolean exist = servicePetRepository.existsById(id);
        if(!exist){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        servicePetRepository.deleteById(id);

    }

    public ServicePet update(ServicePet service, Long id) {
        boolean exist = servicePetRepository.existsById(id);
        if(!exist){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        service.setId(id);
        return servicePetRepository.save(service);
    }

}

