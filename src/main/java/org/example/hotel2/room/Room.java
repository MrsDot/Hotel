package org.example.hotel2.room;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="ROOM")

public class Room {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "MAX_SPACE", nullable = false)
    private Integer maxSpace;

    @Column(name = "PRICE,", nullable = false)
    private Double price;

    @Column(name = "NAME_OF_ROOM")
    private String nameOfRoom;

    @Column(name="IS_AVAILABLE", nullable = false)
    private boolean isAvailable;


    public Room(Integer maxSpace, Double price, String nameOfRoom, boolean isAvailable) {
        this.maxSpace = maxSpace;
        this.price = price;
        this.nameOfRoom = nameOfRoom;
        this.isAvailable = isAvailable;
    }

    public Room(){
    }
}
