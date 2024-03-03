package dev.patika.veterinary.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "animals")
@Data
@AllArgsConstructor
@NoArgsConstructor

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
    @Column(name = "animal_gender")
    private String gender;
    @Column(name = "animal_color")
    private String color;
    @Column(name = "animal_date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "owner_id")
    @JsonBackReference
    private Owner owner;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Vaccine> vaccinations;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.REMOVE)
    private List<Appointment> appointments;



}
