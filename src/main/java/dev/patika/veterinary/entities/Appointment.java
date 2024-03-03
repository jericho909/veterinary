package dev.patika.veterinary.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "appointment_animal_id", referencedColumnName = "animal_id")
    @JsonBackReference
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "appointment_doctor_id", referencedColumnName = "doctor_id")
    @JsonBackReference
    private Doctor doctor;

}
