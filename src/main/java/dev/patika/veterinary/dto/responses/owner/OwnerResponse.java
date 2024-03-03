package dev.patika.veterinary.dto.responses.owner;

import dev.patika.veterinary.entities.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerResponse {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;
    private List<Animal> animals;
}
