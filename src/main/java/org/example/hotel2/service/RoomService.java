package org.example.hotel2.service;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.example.hotel2.dto.RoomDto;

public interface RoomService {
    boolean postRoom (RoomDto roomDto);
}
