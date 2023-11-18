package webminds.group.pet_backend.domain.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webminds.group.pet_backend.domain.user.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
