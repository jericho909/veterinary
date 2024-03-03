package dev.patika.veterinary.dto.responses.appointment;

import dev.patika.veterinary.entities.Animal;
import dev.patika.veterinary.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private Long id;
    private LocalDate date;
    private Long doctorId;
    private Long animalId;
}
