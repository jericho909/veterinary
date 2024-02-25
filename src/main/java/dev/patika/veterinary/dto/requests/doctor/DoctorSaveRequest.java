package dev.patika.veterinary.dto.requests.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSaveRequest {
    @NotNull
    private String name;
    @NotNull
    private String phone;
    @NotNull
    @Email(message = "NOT A VALID E-MAIL ADDRESS")
    private String mail;
    private String city;
}
