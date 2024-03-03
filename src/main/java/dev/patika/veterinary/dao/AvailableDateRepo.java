package dev.patika.veterinary.dao;

import dev.patika.veterinary.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableDateRepo extends JpaRepository<AvailableDate, Long> {
}
