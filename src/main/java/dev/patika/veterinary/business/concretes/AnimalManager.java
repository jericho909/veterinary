package dev.patika.veterinary.business.concretes;

import dev.patika.veterinary.business.abstracts.IAnimalService;
import dev.patika.veterinary.dao.AnimalRepo;
import dev.patika.veterinary.entities.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class AnimalManager implements IAnimalService {
    private final AnimalRepo animalRepo;

    public AnimalManager(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @Override
    public Animal save(Animal animal) {
        return this.animalRepo.save(animal);
    }

    @Override
    public Animal get(int id) {
        return this.animalRepo.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    @Override
    public Animal update(Animal animal) {
        this.get(Math.toIntExact(animal.getId()));
        return this.animalRepo.save(animal);
    }

    @Override
    public Page<Animal> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.animalRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        Animal animalToBeDeleted = this.get(id);
        this.animalRepo.delete(animalToBeDeleted);
        return true;
    }
}
