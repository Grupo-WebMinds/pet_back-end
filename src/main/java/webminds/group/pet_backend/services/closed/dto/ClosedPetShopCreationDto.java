package webminds.group.pet_backend.services.closed.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClosedPetShopCreationDto {

    private List<LocalDate> days;
    private List<Short> week;

}
