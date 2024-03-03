package dev.patika.veterinary.dao;

import dev.patika.veterinary.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepo extends JpaRepository <Owner, Long> {
    List<Owner> findByName(String name);
}
