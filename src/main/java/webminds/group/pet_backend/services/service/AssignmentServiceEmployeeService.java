package webminds.group.pet_backend.services.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webminds.group.pet_backend.domain.service.AssignmentServiceEmployee;
import webminds.group.pet_backend.domain.service.repositories.AssignmentServiceEmployeeRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentServiceEmployeeService {

    private final AssignmentServiceEmployeeRepository assignmentServiceEmployeeRepository;

    public AssignmentServiceEmployee create(AssignmentServiceEmployee assignmentServiceEmployee){
        return assignmentServiceEmployeeRepository.save(assignmentServiceEmployee);
    }

    public Optional<AssignmentServiceEmployee> getById(Long id){
        return assignmentServiceEmployeeRepository.findById(id);
    }

}
