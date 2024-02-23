package dev.patika.veterinary.dto.responses.vaccine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineResponse {
    private int id;
    private String name;
    private String code;
}
