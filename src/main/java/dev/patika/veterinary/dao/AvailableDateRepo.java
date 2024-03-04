package dev.patika.veterinary.dao;

import dev.patika.veterinary.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AvailableDateRepo extends JpaRepository<AvailableDate, Long> {
    boolean existsByDoctorIdAndDate(Long id, LocalDate date);
}
