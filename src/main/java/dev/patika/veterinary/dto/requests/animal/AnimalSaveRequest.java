package dev.patika.veterinary.dto.requests.animal;

import dev.patika.veterinary.entities.Customer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Positive(message = "CUSTOMER ID CANNOT BE NEGATIVE")
    private int customerId;
}
