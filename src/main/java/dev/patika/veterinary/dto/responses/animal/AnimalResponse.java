package dev.patika.veterinary.dto.responses.animal;

import dev.patika.veterinary.dto.responses.customer.CustomerResponse;
import dev.patika.veterinary.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponse {
    private Long id;
    private String name;
    private String species;
    private String breed;
    private List<String> vaccines;
    private CustomerResponse ownerInfo;

}
