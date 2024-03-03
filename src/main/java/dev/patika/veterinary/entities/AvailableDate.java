package dev.patika.veterinary.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import java.time.LocalDate;

@Entity
@Table(name = "available_dates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_date_id")
    private Long id;
    @Column(name = "available_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "available_date_doctor_id", referencedColumnName = "doctor_id")
    @JsonBackReference
    private Doctor doctor;
}
