package dev.patika.veterinary.dao;

import dev.patika.veterinary.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface VaccineRepo extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findAllByAnimalId(Long animalId);
    @Query("SELECT vac FROM Vaccine vac WHERE vac.animal.id = ?1 AND vac.endDate >= ?2 AND upper(vac.code) = upper(?3)")
    Vaccine isVaccineStillActive(Long animalId, LocalDate startDate, String code);

    List<Vaccine> findAllByEndDateBetween(LocalDate startDate, LocalDate endDate);
}
