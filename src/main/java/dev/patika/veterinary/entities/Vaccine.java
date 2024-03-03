package dev.patika.veterinary.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "vaccines")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id")
    private Long id;
    @Column(name = "vaccine_name")
    private String name;
    @Column(name = "vaccine_code")
    private String code;
    @Column(name = "vaccination_date")
    private LocalDate startDate;
    @Column(name = "vaccination_end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "animal_id", referencedColumnName = "animal_id")
    @JsonBackReference
    private Animal animal;
}
