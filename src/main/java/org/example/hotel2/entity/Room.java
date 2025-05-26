package org.example.hotel2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.hotel2.dto.RoomDto;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Long price;
    private boolean isAvailable;

    public RoomDto getRoomDto() {
        RoomDto roomDto = new RoomDto();

        roomDto.setId(id);
        roomDto.setName(name);
        roomDto.setType(type);
        roomDto.setPrice(price);
        roomDto.setAvailable(isAvailable);

        return roomDto;

    }

    @ManyToOne
    @JoinColumn(name="booking_id")
    private Booking booking;
}
