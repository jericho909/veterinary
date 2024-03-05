package dev.patika.veterinary.dto.requests.owner;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerUpdateRequest {
    @NotNull(message = "NAME CANNOT BE EMPTY")
    private String name;
    @NotNull(message = "PHONE CANNOT BE EMPTY")
    private String phone;
    @Email(message = "NOT A VALID E-MAIL ADDRESS")
    @NotNull(message = "EMAIL CANNOT BE EMPTY")
    private String email;
    @NotNull(message = "ADDRESS CANNOT BE EMPTY")
    private String address;
    @NotNull(message = "CITY CANNOT BE EMPTY")
    private String city;
}
