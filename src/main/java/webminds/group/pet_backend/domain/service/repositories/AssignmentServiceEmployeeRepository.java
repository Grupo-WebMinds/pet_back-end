package webminds.group.pet_backend.domain.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webminds.group.pet_backend.domain.service.AssignmentServiceEmployee;

import java.util.List;

public interface AssignmentServiceEmployeeRepository extends JpaRepository<AssignmentServiceEmployee, Long> {

    List<AssignmentServiceEmployee> findByServicePetId(Long id);

}
