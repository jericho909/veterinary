package dev.patika.veterinary.business.abstracts;

import dev.patika.veterinary.entities.Animal;
import org.springframework.data.domain.Page;

public interface IAnimalService {
    Animal save(Animal animal);
    Animal get(int id);
    Animal update(Animal animal);
    Page<Animal> cursor(int page, int pageSize);
    boolean delete(int id);

}
