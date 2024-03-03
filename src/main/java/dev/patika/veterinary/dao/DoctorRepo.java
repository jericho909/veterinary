package dev.patika.veterinary.dao;

import dev.patika.veterinary.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}
