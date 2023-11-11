package webminds.group.pet_backend.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cellPhone;
    private String telephone;
    private LocalDateTime dateBirth;
    private String cpf;
    private LocalDateTime dateCreation;

    @OneToOne
    private AuthUser authUser;

}
