package dev.patika.veterinary.dto.requests.animal;

import dev.patika.veterinary.entities.Owner;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalSaveRequest {
    @NotNull
    private String name;
    @NotNull
    private String species;
    @NotNull
    private String breed;
    @NotNull
    private String gender;
    @NotNull
    private String color;
    @NotNull
    private LocalDate dateOfBirth;
    @Min(value = 1)
    @NotNull
    private Long ownerId;
}
