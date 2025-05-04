package org.example.hotel2.room;

import org.example.hotel2.room.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
