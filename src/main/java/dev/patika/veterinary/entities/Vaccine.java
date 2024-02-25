package dev.patika.veterinary.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Column(name = "vaccine_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "vaccine_name")
    private String name;

    @Column(name = "vaccine_code")
    private String code;

    @Temporal(TemporalType.DATE)
    @Column(name = "vaccine_protectionStrDate")
    private LocalDate startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "vaccine_protectionEndDate")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "animal_vaccine_id", referencedColumnName = "animal_id")
    private Animal animal;
}
