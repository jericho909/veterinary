package dev.patika.veterinary.dto.requests.animal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalUpdateRequest {
    @Positive(message = "ID VALUE CANNOT BE NEGATIVE")
    private int id;
    @NotNull(message = "ANIMAL NAME CANNOT BE EMPTY")
    private String name;
    @NotNull(message = "BREED CANNOT BE EMPTY")
    private String breed;
    @NotNull(message = "SPECIES CANNOT BE EMPTY")
    private String species;
    @NotNull(message = "CUSTOMER ID CANNOT BE EMPTY")
    @Positive(message = "CUSTOMER ID CANNOT BE NEGATIVE")
    private int customerId;
}
