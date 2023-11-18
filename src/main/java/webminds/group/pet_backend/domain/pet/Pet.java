package webminds.group.pet_backend.domain.pet;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webminds.group.pet_backend.domain.user.AuthUser;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String typePet;
    private String race;
    private Double weight;
    private Short size;
    private Short gender;
    private LocalDate dateBirth;
    private LocalDateTime dateCreation;

    @ManyToOne
    private AuthUser authUser;

}
