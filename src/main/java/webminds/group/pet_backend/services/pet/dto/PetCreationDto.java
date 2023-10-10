package webminds.group.pet_backend.services.pet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PetCreationDto {

    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @PastOrPresent
    private LocalDate birthDate;

    @NotBlank
    @Size(min = 3, max = 255)
    private String gender;

    @NotBlank
    @Size(min = 3, max = 255)
    private String size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
