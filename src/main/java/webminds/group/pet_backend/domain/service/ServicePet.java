package webminds.group.pet_backend.domain.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webminds.group.pet_backend.domain.petShop.PetShop;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicePet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Short size;
    private Double price;
    private Short typeService;

    @ManyToOne
    private PetShop petShop;

    @ManyToOne
    private SchedulingHasServicePet schedulingHasServicePet;

}
