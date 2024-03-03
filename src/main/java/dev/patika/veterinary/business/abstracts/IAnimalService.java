package dev.patika.veterinary.business.abstracts;

import dev.patika.veterinary.dto.requests.animal.AnimalSaveRequest;
import dev.patika.veterinary.dto.requests.animal.AnimalUpdateRequest;
import dev.patika.veterinary.dto.responses.animal.AnimalResponse;
import dev.patika.veterinary.entities.Animal;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAnimalService {
    AnimalResponse save(AnimalSaveRequest animalSaveRequest);
    AnimalResponse get(Long id);
    Page<Animal> cursor(int page, int pageSize);
    void delete(Long id);
    AnimalResponse update(Long id, AnimalUpdateRequest animalUpdateRequest);
    List<Animal> findByName(String name);
}
