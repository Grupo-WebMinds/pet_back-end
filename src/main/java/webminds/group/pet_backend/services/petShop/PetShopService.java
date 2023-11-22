package webminds.group.pet_backend.services.petShop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.petShop.repositories.PetShopRepository;
import webminds.group.pet_backend.domain.user.AuthUser;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetShopService {

    private final PetShopRepository petShopRepository;

    public PetShop create(PetShop petShop){
        return petShopRepository.save(petShop);
    }

    public List<PetShop> get(){
        return petShopRepository.findAll();
    }

    public Optional<PetShop> getByUser(Long id){
        return petShopRepository.findByAuthUserId(id);
    }
}
