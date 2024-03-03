package dev.patika.veterinary.business.concretes;

import dev.patika.veterinary.business.abstracts.IVaccineService;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.exceptions.NotFoundException;
import dev.patika.veterinary.core.utils.Msg;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dao.AnimalRepo;
import dev.patika.veterinary.dao.VaccineRepo;
import dev.patika.veterinary.dto.requests.vaccine.VaccineSaveRequest;
import dev.patika.veterinary.dto.requests.vaccine.VaccineUpdateRequest;
import dev.patika.veterinary.dto.responses.vaccine.VaccineResponse;
import dev.patika.veterinary.entities.Animal;
import dev.patika.veterinary.entities.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VaccineManager implements IVaccineService {
    private final VaccineRepo vaccineRepo;
    private final IModelMapper modelMapper;
    private final AnimalManager animalManager;

    public VaccineManager(VaccineRepo vaccineRepo, IModelMapper modelMapper, AnimalManager animalManager) {
        this.vaccineRepo = vaccineRepo;
        this.modelMapper = modelMapper;
        this.animalManager = animalManager;
    }

    @Override
    public VaccineResponse save(VaccineSaveRequest vaccineSaveRequest) {
        Vaccine newVaccine = this.modelMapper.forRequest().map(vaccineSaveRequest, Vaccine.class);
        this.vaccineRepo.save(newVaccine);
        return this.modelMapper.forResponse().map(newVaccine, VaccineResponse.class);
    }

    @Override
    public VaccineResponse get(Long id) {
        Vaccine vaccine = this.vaccineRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
        return this.modelMapper.forResponse().map(vaccine, VaccineResponse.class);
    }

    @Override
    public void delete(Long id) {
        Vaccine vaccineToBeDeleted = this.vaccineRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
        this.vaccineRepo.delete(vaccineToBeDeleted);

    }

    @Override
    public Page<Vaccine> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.vaccineRepo.findAll(pageable);
    }

    @Override
    public VaccineResponse update(Long id, VaccineUpdateRequest vaccineUpdateRequest) {
        Vaccine updatedVaccine = this.vaccineRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
        updatedVaccine.setName(vaccineUpdateRequest.getName());
        updatedVaccine.setCode(vaccineUpdateRequest.getCode());
        updatedVaccine.setStartDate(vaccineUpdateRequest.getStartDate());
        updatedVaccine.setEndDate(vaccineUpdateRequest.getEndDate());
        Animal animal = this.modelMapper.forRequest().map(this.animalManager.get(vaccineUpdateRequest.getAnimalId()), Animal.class);
        updatedVaccine.setAnimal(animal);

        this.vaccineRepo.save(updatedVaccine);

        return this.modelMapper.forResponse().map(updatedVaccine, VaccineResponse.class);
    }

}
