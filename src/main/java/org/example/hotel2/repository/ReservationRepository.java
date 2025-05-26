package org.example.hotel2.repository;

import org.example.hotel2.entity.Booking;
import org.example.hotel2.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Booking, Long>{
    List<Booking> rooms(List<Room> rooms);
}
