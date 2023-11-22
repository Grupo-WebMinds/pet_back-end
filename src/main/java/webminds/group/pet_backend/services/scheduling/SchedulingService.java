package webminds.group.pet_backend.services.scheduling;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webminds.group.pet_backend.domain.scheduling.Scheduling;
import webminds.group.pet_backend.domain.scheduling.repositories.SchedulingRepository;
import webminds.group.pet_backend.domain.service.AssignmentServiceEmployee;

@Service
@RequiredArgsConstructor
public class SchedulingService {

    private final SchedulingRepository schedulingRepository;
    public Scheduling create(Scheduling scheduling){
        return schedulingRepository.save(scheduling);
    }


}
