package dev.patika.veterinary.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "available_dates")
@Data
public class AvailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_date_id", columnDefinition = "serial")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "available_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "doctor_available_date_id", referencedColumnName = "doctor_id")
    private Doctor doctor;
}
