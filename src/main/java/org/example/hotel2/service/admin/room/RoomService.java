package org.example.hotel2.service.admin.room;

import org.example.hotel2.dto.RoomDto;
import org.example.hotel2.dto.RoomResponseDto;

public interface RoomService {

    boolean postRoom (RoomDto roomDto);

    RoomResponseDto getAllRooms(int pageNumber);
}
