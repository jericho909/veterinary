package dev.patika.veterinary.dto.requests.customer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {
    @NotNull(message = "NAME CANNOT BE EMPTY")
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
}
