package dev.patika.veterinary.dto.requests.animal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalUpdateRequest {
    @NotNull(message = "NAME CANNOT BE EMPTY")
    private String name;
    @NotNull(message = "SPECIES CANNOT BE EMPTY")
    private String species;
    @NotNull(message = "BREED CANNOT BE EMPTY")
    private String breed;
    @NotNull(message = "GENDER CANNOT BE EMPTY")
    private String gender;
    @NotNull(message = "COLOR CANNOT BE EMPTY")
    private String color;
    @NotNull(message = "DATE OF BIRTH CANNOT BE EMPTY")
    private LocalDate dateOfBirth;
    @Min(value = 1)
    @NotNull(message = "OWNER ID CANNOT BE NULL")
    private Long ownerId;
}
