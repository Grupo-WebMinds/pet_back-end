package webminds.group.pet_backend.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import webminds.group.pet_backend.domain.closed.ClosedDaysEmployee;
//import webminds.group.pet_backend.domain.closed.ClosedDaysPetShop;
//import webminds.group.pet_backend.domain.closed.ClosedWeekEmployee;
import webminds.group.pet_backend.domain.petShop.PetShop;
import webminds.group.pet_backend.domain.service.AssignmentServiceEmployee;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime timeStart;
    private LocalTime timeEnd;

    @ManyToOne
    private AuthUser authUser;

    @ManyToOne
    private PetShop petShop;

//    @OneToMany(mappedBy = "employee")
//    private List<ClosedDaysPetShop> closedDaysEmployee;

//    @OneToMany(mappedBy = "employee")
//    private List<ClosedWeekEmployee> closedWeekEmployee;

}

