//package org.example.hotel2.configuration;
//
//import org.antlr.v4.runtime.misc.Pair;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Date;
//
//@Configuration
//public class DatabaseInit {
//
//
//    @Bean
//    CommandLineRunner initDatabase(ReservationService bookingService) {
//        return args -> {
//            Pair<Date, Date> firstDatePair = initDates(2);
//            bookingService.saveBooking(
//                    new Booking(
//                            null,
//                            "John Doe",
//                            "Deluxe",
//                            firstDatePair.a,
//                            firstDatePair.b,
//                            250
//                    )
//            );
//
//            Pair<Date, Date> secondDatePair = initDates(3);
//            bookingService.saveBooking(
//                    new Booking(
//                            null,
//                            "Jane Doe",
//                            "Suite",
//                            secondDatePair.a,
//                            secondDatePair.b,
//                            375
//                    )
//            );
//        };
//    }
//}
