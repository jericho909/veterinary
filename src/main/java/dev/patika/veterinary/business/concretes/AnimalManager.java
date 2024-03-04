package dev.patika.veterinary.business.concretes;

import dev.patika.veterinary.business.abstracts.IAnimalService;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.exceptions.NotFoundException;
import dev.patika.veterinary.core.utils.Msg;
import dev.patika.veterinary.dao.AnimalRepo;
import dev.patika.veterinary.dao.OwnerRepo;
import dev.patika.veterinary.dto.requests.animal.AnimalSaveRequest;
import dev.patika.veterinary.dto.requests.animal.AnimalUpdateRequest;
import dev.patika.veterinary.dto.responses.animal.AnimalResponse;
import dev.patika.veterinary.entities.Animal;
import dev.patika.veterinary.entities.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalManager implements IAnimalService {
    private final AnimalRepo animalRepo;
    private final IModelMapper modelMapper;
    private final OwnerRepo ownerRepo;

    public AnimalManager(AnimalRepo animalRepo, IModelMapper modelMapper, OwnerRepo ownerRepo) {
        this.animalRepo = animalRepo;
        this.modelMapper = modelMapper;
        this.ownerRepo = ownerRepo;
    }

    @Override
    public AnimalResponse save(AnimalSaveRequest animalSaveRequest) {
        Animal newAnimal = this.modelMapper.forRequest().map(animalSaveRequest, Animal.class);
        newAnimal.setId(null);
        Owner owner = this.ownerRepo.findById(animalSaveRequest.getOwnerId()).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
        newAnimal.setOwner(owner);
        this.animalRepo.save(newAnimal);
        return this.modelMapper.forResponse().map(newAnimal, AnimalResponse.class);
    }

    @Override
    public AnimalResponse get(Long id) {
        Animal animal = this.animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
        return this.modelMapper.forResponse().map(animal, AnimalResponse.class);
    }

    @Override
    public Page<Animal> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.animalRepo.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        Animal animalToBeDeleted = this.animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
        this.animalRepo.delete(animalToBeDeleted);
    }

    @Override
    public AnimalResponse update(Long id, AnimalUpdateRequest animalUpdateRequest) {
        Animal animalToBeUpdated = this.animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));

        animalToBeUpdated.setName(animalUpdateRequest.getName());
        animalToBeUpdated.setSpecies(animalUpdateRequest.getSpecies());
        animalToBeUpdated.setBreed(animalUpdateRequest.getBreed());
        animalToBeUpdated.setGender(animalUpdateRequest.getGender());
        animalToBeUpdated.setColor(animalUpdateRequest.getColor());
        animalToBeUpdated.setDateOfBirth(animalUpdateRequest.getDateOfBirth());
        return this.modelMapper.forResponse().map(this.animalRepo.save(animalToBeUpdated), AnimalResponse.class);
    }

    @Override
    public List<Animal> findByName(String name) {
        return this.animalRepo.findByName(name);
    }
}
