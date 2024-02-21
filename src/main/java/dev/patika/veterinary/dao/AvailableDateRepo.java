package dev.patika.veterinary.dao;

import dev.patika.veterinary.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate, Integer> {
}
