package webminds.group.pet_backend.domain.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webminds.group.pet_backend.domain.scheduling.Scheduling;
import webminds.group.pet_backend.domain.user.Employee;

import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentServiceEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ServicePet servicePet;


    @ManyToOne
    private Employee employee;

    private LocalTime timeWork;

    @OneToMany(mappedBy = "assignmentServiceEmployee")
    private List<Scheduling> listScheduling;

}
