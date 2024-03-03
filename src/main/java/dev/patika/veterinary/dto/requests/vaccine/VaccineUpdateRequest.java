package dev.patika.veterinary.dto.requests.vaccine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineUpdateRequest {
    private String name;
    private String code;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long animalId;
}
