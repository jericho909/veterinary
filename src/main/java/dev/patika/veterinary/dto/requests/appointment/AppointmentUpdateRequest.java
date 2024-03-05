package dev.patika.veterinary.dto.requests.appointment;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateRequest {
    @NotNull(message = "DATE CANNOT BE EMPTY")
    private LocalDateTime date;
    @Min(value = 1)
    @NotNull(message = "DOCTOR ID CANNOT BE EMPTY")
    private Long doctorId;
    @NotNull(message = "ANIMAL ID CANNOT BE EMPTY")
    @Min(value = 1)
    private Long animalId;
}
