package dev.patika.veterinary.dto.requests.availableDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateSaveRequest {
    @NotNull(message = "DATE CANNOT BE EMPTY")
    private LocalDate date;
    @Min(value = 1)
    @NotNull(message = "DOCTOR ID CANNOT BE EMPTY")
    private Long doctorId;
}
