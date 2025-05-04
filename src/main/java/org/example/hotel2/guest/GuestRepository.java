package org.example.hotel2.guest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
    List<Guest> findGuestByLastName(String lastName);
}
