package dev.patika.veterinary.dto.requests.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateRequest {
    private LocalDateTime date;
    private Long doctorId;
    private Long animalId;
}
