package org.example.hotel2;

import org.example.hotel2.guest.Guest;
import org.example.hotel2.guest.GuestRepository;
import org.example.hotel2.reservation.Reservation;
import org.example.hotel2.reservation.ReservationRepository;
import org.example.hotel2.room.Room;
import org.example.hotel2.room.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Hotel2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext contex = SpringApplication.run(Hotel2Application.class, args);

//        //pobranie danych od użytkownika
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Please enter firstname of the guest: [Confirm Enter]");
//        String firstName = scan.nextLine();
//        System.out.println("Your firstname is " + firstName);
//
//        System.out.println("Please enter lastname of the guest: [Confirm Enter]");
//        String lastName = scan.nextLine();
//        System.out.println("Your lastname is " + lastName);
//
//        System.out.println("Please enter PESEL of the guest: [Confirm Enter]");
//        String peselNo = scan.nextLine();
//        System.out.println("Your pesel is " + peselNo);
//
//        System.out.println("Please enter YYYY-MM-DD of birth of the guest: [Confirm Enter]");
//        String dateOfBirth = scan.nextLine();
//        System.out.println("Your dateOfBirth is " + dateOfBirth);
//        scan.close();
//
//        Guest guestFromConsole = new Guest(firstName, lastName, peselNo, dateOfBirth);
//        System.out.println(guestFromConsole);

        System.exit(0);
    }

    @Bean
    public CommandLineRunner commandLineRunnerGuest(GuestRepository guestRepository) {
        return args -> {
            System.out.println(guestRepository.findAll());
            insertGuest(guestRepository);
            System.out.println(guestRepository.findAll());
        };
    }

    @Bean
    public CommandLineRunner commandLineRunnerRoom(RoomRepository roomRepository) {
        return args -> {
            System.out.println(roomRepository.findAll());
            insertRoom(roomRepository);
        };
    }

    @Bean
    public CommandLineRunner commandLineRunnerReservation(ReservationRepository reservationRepository) {
        return args -> {
            System.out.println(reservationRepository.findAll());
            insertRoom(reservationRepository);
        };
    }

    private void insertGuest(GuestRepository guestRepository) {
        guestRepository.save(new Guest("1999-09-09", "99090912345", "Anna", "Boćkowska"));
        guestRepository.save(new Guest("1998-09-09", "98090912345", "Katarzyna", "Boćkowska"));
        guestRepository.save(new Guest("1997-09-09", "97090912345", "Jolanta", "Boćkowska"));
        guestRepository.save(new Guest("1996-09-09", "96090912345", "Stefania", "Boćkowska"));
    }

    private void insertRoom(RoomRepository roomRepository) {
        roomRepository.save(new Room(1, 120.00, "Ogień", true));
        roomRepository.save(new Room(2, 400.00, "Woda", true));
        roomRepository.save(new Room(1, 133.00, "Powietrze", false));
        roomRepository.save(new Room(1, 159.00, "Ziemia", true));
    }

    private void insertRoom(ReservationRepository reservationRepository) {
        reservationRepository.save(new Reservation(
                LocalDate.of(2025, 5, 1),
                LocalDate.of(2025, 5, 20),
                LocalDate.of(2025, 5, 22),
                true,
                "Booking"));
    }
}
