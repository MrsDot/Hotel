package org.example.hotel2.repository;

import org.example.hotel2.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
    List<Guest> findGuestByLastName(String lastName);
}
