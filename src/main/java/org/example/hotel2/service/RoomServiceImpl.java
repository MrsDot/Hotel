package org.example.hotel2.service;

import lombok.RequiredArgsConstructor;
import org.example.hotel2.dto.RoomDto;
import org.example.hotel2.dto.RoomResponseDto;
import org.example.hotel2.entity.Room;
import org.example.hotel2.repository.RoomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public boolean postRoom(RoomDto roomDto) {
        try {

            Room room = new Room();
            room.setName(roomDto.getName());
            room.setPrice(roomDto.getPrice());
            room.setMaxSpace(roomDto.getMaxSpace());
            room.setAvailable(true);

            roomRepository.save(room);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public RoomResponseDto getAllRooms(int pageNumber) {
//        Pageable pageable = PageRequest.of(pageNumber, 10);
//        Page<Room> roomPage = roomRepository.findAll(pageable);
//
//    }
}

