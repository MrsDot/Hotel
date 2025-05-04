package org.example.hotel2.reservation;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "RESERVATION")

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "RESERVATION_DATE", nullable = false)
    private LocalDate reservationDate;

    @Column(name = "CHECK_IN_DATE", nullable = false)
    private LocalDate checkInDate;

    @Column(name = "CHECK_OUT_DATE", nullable = false)
    private LocalDate checkOutDate;

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean isActive;

    @Column(name = "RESERVATION_SOURCE")
    private String reservationSource;

    public Reservation() {
    }

    public Reservation(LocalDate reservationDate, LocalDate checkInDate, LocalDate checkOutDate, boolean isActive, String reservationSource) {
        this.reservationDate = reservationDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isActive = isActive;
        this.reservationSource = reservationSource;
    }
}



