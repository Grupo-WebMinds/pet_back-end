//package webminds.group.pet_backend.domain.closed;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import webminds.group.pet_backend.domain.user.Employee;
//
//import java.time.LocalDate;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class ClosedDaysEmployee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private LocalDate dateClose;
//
//    @ManyToOne
//    private Employee employee;
//
//}
