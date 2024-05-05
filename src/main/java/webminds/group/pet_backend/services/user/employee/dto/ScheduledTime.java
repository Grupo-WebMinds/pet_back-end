package webminds.group.pet_backend.services.user.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduledTime {

    private LocalTime timeStart;
    private LocalTime timeEnd;
    private LocalDateTime dateScheduling;

}
