package dev.patika.veterinary.dto.responses.vaccine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineResponse {
    private Long id;
    private String name;
    private String code;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long animalId;
}
