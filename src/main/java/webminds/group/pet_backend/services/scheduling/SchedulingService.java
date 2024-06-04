package webminds.group.pet_backend.services.scheduling;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webminds.group.pet_backend.domain.scheduling.Scheduling;
import webminds.group.pet_backend.domain.scheduling.repositories.SchedulingRepository;
import webminds.group.pet_backend.domain.service.AssignmentServiceEmployee;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchedulingService {

    private final SchedulingRepository schedulingRepository;
    public Scheduling create(Scheduling scheduling){
        return schedulingRepository.save(scheduling);
    }

    public Scheduling update(Scheduling scheduling, Long id){

        boolean exist = schedulingRepository.existsById(id);
        if(!exist){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        Scheduling newSch = scheduling;
        newSch.setId(id);
        return schedulingRepository.save(newSch);
    }

    public List<Scheduling> get(){
        return schedulingRepository.findAll();
    }

    public Optional<Scheduling> getById(Long id){
        return schedulingRepository.findById(id);
    }


    public void delete(Long id){
        boolean exist = schedulingRepository.existsById(id);
        if(!exist){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        schedulingRepository.deleteById(id);

    }

    public List<Scheduling> getByAuthUser(Long id) {
        return schedulingRepository.findAllByPetAuthUserId(id);
    }

    public Object getDadosDono(Long id){
        return schedulingRepository.getDadosDono(id);
    }

}
