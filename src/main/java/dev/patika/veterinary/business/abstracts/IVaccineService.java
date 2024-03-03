package dev.patika.veterinary.business.abstracts;

import dev.patika.veterinary.dto.requests.vaccine.VaccineSaveRequest;
import dev.patika.veterinary.dto.requests.vaccine.VaccineUpdateRequest;
import dev.patika.veterinary.dto.responses.vaccine.VaccineResponse;
import dev.patika.veterinary.entities.Vaccine;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {
    VaccineResponse save(VaccineSaveRequest vaccineSaveRequest);
    VaccineResponse get(Long id);
    void delete(Long id);
    Page<Vaccine> cursor(int page, int pageSize);
    VaccineResponse update(Long id, VaccineUpdateRequest vaccineUpdateRequest);
    List<Vaccine> findAllByAnimalId(Long animalId);
    List<Vaccine> findAllByEndDateBetween(LocalDate startDate, LocalDate endDate);
}
