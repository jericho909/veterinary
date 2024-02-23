package dev.patika.veterinary.dto.requests.customer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    @NotNull
    @Positive(message = "ID CANNOT BE NEGATIVE")
    private int id;
    @NotNull
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
}
