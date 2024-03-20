package webminds.group.pet_backend.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.petShop.PetShop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private Short userType;
    private String name;
    private String cellPhone;
    private String telephone;
    private LocalDate dateBirth;
    private String cpf;
    private Short gender;
    private LocalDateTime dateCreation;

    @OneToMany(mappedBy = "authUser")
    private List<PetShop> listPetShop;

    @OneToMany(mappedBy = "authUser")
    private List<Employee> listEmployee;

    @OneToMany(mappedBy = "authUser")
    private List<Pet> listPet;

}
