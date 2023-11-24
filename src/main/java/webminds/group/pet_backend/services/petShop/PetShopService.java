package webminds.group.pet_backend.services.petShop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.petShop.repositories.PetShopRepository;
import webminds.group.pet_backend.domain.user.AuthUser;
import webminds.group.pet_backend.exception.ConflictCreateException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetShopService {

    private final PetShopRepository petShopRepository;

    public PetShop create(PetShop petShop){

        boolean exist = petShopRepository.existsByCnpj(petShop.getCnpj());

        if(exist){
            throw new ConflictCreateException("petShop", petShop.getCnpj());
        }

        return petShopRepository.save(petShop);
    }

    public List<PetShop> get(){
        return petShopRepository.findAll();
    }

    public Optional<PetShop> getById(Long id){
        return petShopRepository.findById(id);
    }

    public Optional<PetShop> getByUser(Long id){
        return petShopRepository.findByAuthUserId(id);
    }

    public void delete(Long id){
        boolean exist = petShopRepository.existsById(id);
        if(!exist){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        petShopRepository.deleteById(id);

    }

}
