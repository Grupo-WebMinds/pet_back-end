package webminds.group.pet_backend.domain.scheduling.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import webminds.group.pet_backend.domain.scheduling.Scheduling;

import java.util.List;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {

    List<Scheduling> findAllByPetAuthUserId(Long id);

    @Query("SELECT count(s.id), COALESCE(SUM(sp.price), 0) FROM Scheduling s inner join AssignmentServiceEmployee ase on s.assignmentServiceEmployee.id = ase.id inner join Employee e on ase.employee.id = e.id inner join ServicePet sp on ase.servicePet.id = sp.id inner join PetShop ps on sp.petShop.id = ps.id inner join AuthUser au on ps.authUser.id = au.id where au.id = :id and month(s.dateScheduling) = MONTH(current_date()) and YEAR(s.dateScheduling) = YEAR(current_date())")
    Object getDadosDono(Long id);

}
