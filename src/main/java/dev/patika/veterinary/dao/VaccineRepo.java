package dev.patika.veterinary.dao;

import dev.patika.veterinary.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Integer> {
}
