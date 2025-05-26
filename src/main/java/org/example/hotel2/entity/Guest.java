package org.example.hotel2.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="GUEST")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "PESEL")
    private String pesel;

    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private String dateOfBirth;

    public Guest() {
    }

    public Guest(String firstName, String lastName, String pesel, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
    }
}
