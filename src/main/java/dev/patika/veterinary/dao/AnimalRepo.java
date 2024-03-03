package dev.patika.veterinary.dao;

import dev.patika.veterinary.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnimalRepo extends JpaRepository<Animal, Long> {
    List<Animal> findByName(String name);
}
