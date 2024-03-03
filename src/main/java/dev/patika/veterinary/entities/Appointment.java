package dev.patika.veterinary.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Column(name = "appointment_id")
    private Long id;
    @Column(name = "appointment_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "appointment_animal_id", referencedColumnName = "animal_id")
    @JsonBackReference
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "appointment_doctor_id", referencedColumnName = "doctor_id")
    @JsonBackReference
    private Doctor doctor;

}
