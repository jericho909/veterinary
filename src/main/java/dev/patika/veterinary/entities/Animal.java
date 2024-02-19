package dev.patika.veterinary.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "animals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Long id;

    @Column(name = "animal_name")
    private String name;

    @Column(name = "animal_species")
    private String species;

    @Column(name = "animal_breed")
    private String breed;

    @Enumerated(EnumType.STRING)
    @Column(name = "animal_gender")
    private GENDER gender;

    @Column(name = "animal_colour")
    private String colour;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    private enum GENDER{
        MALE,
        FEMALE
    }
}
