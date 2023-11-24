package webminds.group.pet_backend.services.user.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webminds.group.pet_backend.domain.user.Employee;
import webminds.group.pet_backend.domain.user.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    public List<Employee> get(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(Long id){
        return employeeRepository.findById(id);
    }

    public void delete(Long id){
        boolean exist = employeeRepository.existsById(id);
        if(!exist){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        employeeRepository.deleteById(id);

    }

}
