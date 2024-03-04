package dev.patika.veterinary.dao;

import dev.patika.veterinary.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    boolean existsByDoctorIdAndDateBetween(Long id, LocalDateTime startTime, LocalDateTime endTime);
    List<Appointment> findAllByDoctorIdAndDateBetween(Long id, LocalDateTime startTime, LocalDateTime endTime);
    List<Appointment> findAllByAnimalIdAndDateBetween(Long id, LocalDateTime startTime, LocalDateTime endTime);
}
