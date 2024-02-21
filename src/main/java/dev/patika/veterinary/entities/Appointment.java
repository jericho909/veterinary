package dev.patika.veterinary.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", columnDefinition = "serial")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "appointment_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "animal_appointment_id", referencedColumnName = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "doctor_appointment_id", referencedColumnName = "doctor_id")
    private Doctor doctor;
}
