package dev.patika.veterinary.dto.requests.vaccine;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineUpdateRequest {
    @NotNull(message = "NAME CANNOT BE EMPTY")
    private String name;
    @NotNull(message = "CODE CANNOT BE EMPTY")
    private String code;
    @NotNull(message = "START DATE CANNOT BE EMPTY")
    private LocalDate startDate;
    @NotNull(message = "END DATE CANNOT BE EMPTY")
    private LocalDate endDate;
    @NotNull(message = "ANIMAL ID CANNOT BE EMPTY")
    @Min(value = 1)
    private Long animalId;
}
