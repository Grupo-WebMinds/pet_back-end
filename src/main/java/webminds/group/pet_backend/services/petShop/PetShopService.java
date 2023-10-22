package webminds.group.pet_backend.services.petShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.petShop.repositories.PetShopRepository;
import webminds.group.pet_backend.services.petShop.dto.PetShopCreationDto;
import webminds.group.pet_backend.services.petShop.dto.PetShopDto;
import webminds.group.pet_backend.services.petShop.dto.PetShopMapper;

import java.util.List;
import java.util.Optional;

@Service
public class PetShopService {

    @Autowired
    private PetShopRepository petShopRepository;

    public PetShopDto create(PetShopCreationDto petShopCreationDto){
        final PetShop newPetShop = PetShopMapper.of(petShopCreationDto);

        return PetShopMapper.ofDto(this.petShopRepository.save(newPetShop));
    }

    public List<PetShopDto> get(){
        List<PetShop> petShops = this.petShopRepository.findAll();

        return petShops.stream().map(PetShopMapper::ofDto).toList();
    }

    public PetShopDto getById(Long id){
        Optional<PetShop> petShopOpt = this.petShopRepository.findById(id);
        if (petShopOpt.isEmpty()){
            return null;
        }

        PetShop petShop = petShopOpt.get();
        return PetShopMapper.ofDto(petShop);

    }

    public boolean delete(Long id){
        boolean exist = this.petShopRepository.existsById(id);
        if (exist){
            this.petShopRepository.deleteById(id);
        }
        return exist;
    }

    public PetShopDto update(PetShopCreationDto petShopCreationDto, Long id){
        boolean exist = this.petShopRepository.existsById(id);
        if (exist){
            PetShop petShop = PetShopMapper.of(petShopCreationDto);
            petShop.setId(id);
            petShopRepository.save(petShop);
            return PetShopMapper.ofDto(petShop);
        }
        return null;
    }

}
