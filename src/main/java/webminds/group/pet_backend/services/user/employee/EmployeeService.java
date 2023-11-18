package webminds.group.pet_backend.services.user.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webminds.group.pet_backend.domain.user.Employee;
import webminds.group.pet_backend.domain.user.repositories.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

}
