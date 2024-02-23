package dev.patika.veterinary.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "animals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id", columnDefinition = "serial")
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

    @OneToMany(mappedBy = "animal", cascade = CascadeType.REMOVE)
    private List<Vaccine> vaccines;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_customer_id", referencedColumnName = "customer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    @OneToMany(mappedBy = "animal")
    private List<Appointment> appointments;

    private enum GENDER{
        MALE,
        FEMALE
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", breed='" + breed + '\'' +
                ", gender=" + gender +
                ", colour='" + colour + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
