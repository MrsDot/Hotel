package org.example.hotel2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Room {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer maxSpace;
    private Double price;
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name="booking_id")
    private Booking booking;
}
