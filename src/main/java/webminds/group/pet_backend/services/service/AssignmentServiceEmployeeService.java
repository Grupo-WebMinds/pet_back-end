package webminds.group.pet_backend.services.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webminds.group.pet_backend.domain.service.AssignmentServiceEmployee;
import webminds.group.pet_backend.domain.service.repositories.AssignmentServiceEmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentServiceEmployeeService {

    private final AssignmentServiceEmployeeRepository assignmentServiceEmployeeRepository;

    public AssignmentServiceEmployee create(AssignmentServiceEmployee assignmentServiceEmployee){
        return assignmentServiceEmployeeRepository.save(assignmentServiceEmployee);
    }

    public AssignmentServiceEmployee update(AssignmentServiceEmployee assignmentServiceEmployee, Long id){
        boolean exist = assignmentServiceEmployeeRepository.existsById(id);
        if(!exist){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        assignmentServiceEmployee.setId(id);
        return assignmentServiceEmployeeRepository.save(assignmentServiceEmployee);
    }

    public void delete(Long id){
        boolean exist = assignmentServiceEmployeeRepository.existsById(id);
        if(!exist){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        assignmentServiceEmployeeRepository.deleteById(id);

    }

    public Optional<AssignmentServiceEmployee> getById(Long id){
        return assignmentServiceEmployeeRepository.findById(id);
    }

    public List<AssignmentServiceEmployee> getByService(Long id){
        return assignmentServiceEmployeeRepository.findByServicePetId(id);
    }

}
