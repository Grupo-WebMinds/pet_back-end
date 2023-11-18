package webminds.group.pet_backend.domain.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webminds.group.pet_backend.domain.user.Employee;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentServiceEmployee {

    @Id
    @ManyToOne
    private ServicePet servicePet;

    @Id
    @ManyToOne
    private Employee employee;

    private LocalTime timeWork;

}
