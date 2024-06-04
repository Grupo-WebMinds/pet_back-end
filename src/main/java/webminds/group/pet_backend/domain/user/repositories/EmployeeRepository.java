package webminds.group.pet_backend.domain.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import webminds.group.pet_backend.domain.user.Employee;
import webminds.group.pet_backend.services.user.employee.dto.ScheduledTime;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

        @Query("SELECT e.timeStart, e.timeEnd, s.dateScheduling FROM Employee e LEFT JOIN AssignmentServiceEmployee ase ON e.id = ase.employee.id LEFT JOIN Scheduling s ON ase.id = s.assignmentServiceEmployee.id WHERE e.authUser.id = :id AND DATE(s.dateScheduling) = :date")
        List<ScheduledTime> getHorarioAgendados(Long id, LocalDate date);


}
