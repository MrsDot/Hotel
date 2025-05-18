package org.example.hotel2;

import org.example.hotel2.repository.GuestRepository;
import org.example.hotel2.repository.ReservationRepository;
import org.example.hotel2.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Hotel2Application {

    public static void main(String[] args) {
        SpringApplication.run(Hotel2Application.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunnerGuest(GuestRepository guestRepository) {
//        return args -> {
//            System.out.println(guestRepository.findAll());
//            insertGuest(guestRepository);
//            System.out.println(guestRepository.findAll());
//        };
//    }

//    @Bean
//    public CommandLineRunner commandLineRunnerRoom(RoomRepository roomRepository) {
//        return args -> {
//            System.out.println(roomRepository.findAll());
//            insertRoom(roomRepository);
//        };
//    }
//
//    @Bean
//    @Transactional
//    public CommandLineRunner commandLineRunnerReservation(ReservationRepository reservationRepository) {
//        return args -> {
//            System.out.println(reservationRepository.findAll());
//            insertReservation(reservationRepository);
//        };
//    }

//    private void insertGuest(GuestRepository guestRepository) {
//        guestRepository.save(new Guest("1999-09-09", "99090912345", "Anna", "1999-09-12"));
//        guestRepository.save(new Guest("1998-09-09", "98090912345", "Katarzyna", "1999-09-09"));
//    }

//    private void insertRoom(RoomRepository roomRepository) {
//
//        Room room1 = new Room(1L, new ReservationService(null, null, null), 1, 120.00, "Ogień", true);
//        Room room2 = new Room(2L , new ReservationService(null, null, null),2, 400.00, "Woda", true);
//        List<Room> rooms = Arrays.asList(room1, room2);
//        roomRepository.saveAll(rooms);
//    }
//
//    private void insertReservation(ReservationRepository reservationRepository) {
//        reservationRepository.save(new ReservationService(null, null, null));
//    }
}
